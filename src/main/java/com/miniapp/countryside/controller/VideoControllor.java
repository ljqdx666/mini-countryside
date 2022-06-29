package com.miniapp.countryside.controller;

import com.miniapp.countryside.dto.VideoCreateRequest;
import com.miniapp.countryside.mapper.VideoMapper;
import com.miniapp.countryside.repository.VideoRepository;
import com.miniapp.countryside.service.VideoService;
import com.miniapp.countryside.vo.SuccessVo;
import com.miniapp.countryside.vo.VideoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/video")
public class VideoControllor {
    VideoService videoService;

    VideoMapper videoMapper;

    @GetMapping("")
    List<VideoVo>list(){return videoService.list().stream().map(videoMapper::toVo).collect(Collectors.toList());}

    @GetMapping("/me/{creatorName}")
    List<VideoVo>findMine(@PathVariable String creatorName){return videoService.findMine(creatorName).stream().map(videoMapper::toVo).collect(Collectors.toList());}

    @PostMapping("")
    VideoVo create(@Validated @RequestBody VideoCreateRequest videoCreateRequest){
        return  videoMapper.toVo(videoService.create(videoCreateRequest));
    }

    @DeleteMapping("/{id}")
    SuccessVo delete(@PathVariable String id){return videoService.delete(id);}

    @GetMapping("/add/{id}")
    VideoVo addLike(@PathVariable String id){return videoMapper.toVo(videoService.addLike(id));}

    @GetMapping("/cancel/{id}")
    VideoVo cancelLike(@PathVariable String id){return videoMapper.toVo(videoService.cancelLike(id));}

    @Autowired
    public void setVideoService(VideoService videoService) {
        this.videoService = videoService;
    }

    @Autowired
    public void setVideoMapper(VideoMapper videoMapper) {
        this.videoMapper = videoMapper;
    }
}
