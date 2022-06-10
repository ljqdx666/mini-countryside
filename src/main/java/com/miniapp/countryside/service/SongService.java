package com.miniapp.countryside.service;

import com.miniapp.countryside.dto.SongCreateRequest;
import com.miniapp.countryside.dto.SongDto;

import java.util.List;

public interface SongService {
    List<SongDto>list();

    SongDto create(SongCreateRequest songCreateRequest);
}
