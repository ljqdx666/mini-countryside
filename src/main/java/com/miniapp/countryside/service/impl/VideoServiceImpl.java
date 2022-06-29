package com.miniapp.countryside.service.impl;

import com.miniapp.countryside.dto.VideoCreateRequest;
import com.miniapp.countryside.dto.VideoDto;
import com.miniapp.countryside.entity.Video;
import com.miniapp.countryside.exception.BizException;
import com.miniapp.countryside.exception.ExceptionType;
import com.miniapp.countryside.mapper.VideoMapper;
import com.miniapp.countryside.repository.VideoRepository;
import com.miniapp.countryside.service.VideoService;
import com.miniapp.countryside.vo.SuccessVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VideoServiceImpl extends BaseService implements VideoService {

    VideoRepository videoRepository;
    VideoMapper videoMapper;

    @Override
    public List<VideoDto> list() {
        return videoRepository.findAll().stream().map(videoMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<VideoDto> findMine(String creatorName) {
        try {
            creatorName = new String(creatorName.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List<Video> videos=videoRepository.getAllByCreatorName(creatorName);
        if (videos.size()==0){
            throw new BizException(ExceptionType.NO_MINE_VIDEO);
        }
        return videos.stream().map(videoMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public VideoDto create(VideoCreateRequest videoCreateRequest) {
        Video video=videoMapper.createEntity(videoCreateRequest);
        video.setLikeNum(0);
        return videoMapper.toDto(videoRepository.save(video));
    }

    @Override
    public SuccessVo delete(String id) {
        videoRepository.delete(getById(id));
        SuccessVo successVo=new SuccessVo();
        successVo.setCode("删除成功");
        return successVo;
    }

    @Override
    public VideoDto addLike(String id) {
        Video video=getById(id);
        Integer likeNum=video.getLikeNum();
        video.setLikeNum(likeNum+1);
        return videoMapper.toDto(videoRepository.save(video));
    }

    @Override
    public VideoDto cancelLike(String id) {
        Video video=getById(id);
        Integer likeNum=video.getLikeNum();
        video.setLikeNum(likeNum-1);
        return videoMapper.toDto(videoRepository.save(video));
    }

    private Video getById(String id){
        Optional<Video> video=videoRepository.findById(id);
        if ((!video.isPresent())){
            throw new BizException(ExceptionType.VIDEO_NOT_FOUND);
        }
        return video.get();
    }

    @Autowired
    public void setVideoRepository(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Autowired
    public void setVideoMapper(VideoMapper videoMapper) {
        this.videoMapper = videoMapper;
    }
}
