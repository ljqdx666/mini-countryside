package com.miniapp.countryside.service;

import com.miniapp.countryside.dto.VideoCreateRequest;
import com.miniapp.countryside.dto.VideoDto;

import java.util.List;

public interface VideoService {
    List<VideoDto> list();

    List<VideoDto> findMine(String creatorName);

    VideoDto create(VideoCreateRequest videoCreateRequest);

    void delete(String id);

    VideoDto addLike(String id);

    VideoDto cancelLike(String id);
}
