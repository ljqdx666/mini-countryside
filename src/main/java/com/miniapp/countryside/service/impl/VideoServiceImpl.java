package com.miniapp.countryside.service.impl;

import com.miniapp.countryside.dto.VideoCreateRequest;
import com.miniapp.countryside.dto.VideoDto;
import com.miniapp.countryside.entity.Video;
import com.miniapp.countryside.mapper.VideoMapper;
import com.miniapp.countryside.repository.VideoRepository;
import com.miniapp.countryside.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public VideoDto create(VideoCreateRequest videoCreateRequest) {
        Video video=videoMapper.createEntity(videoCreateRequest);
        video.setLikeNum(0);
        return videoMapper.toDto(videoRepository.save(video));
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
