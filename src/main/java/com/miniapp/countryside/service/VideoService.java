package com.miniapp.countryside.service;

import com.miniapp.countryside.dto.VideoCreateRequest;
import com.miniapp.countryside.dto.VideoDto;

import java.util.List;

public interface VideoService {
    List<VideoDto> list();

    VideoDto create(VideoCreateRequest videoCreateRequest);
}
