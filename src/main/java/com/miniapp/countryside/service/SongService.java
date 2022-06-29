package com.miniapp.countryside.service;

import com.miniapp.countryside.dto.SongCreateRequest;
import com.miniapp.countryside.dto.SongDto;
import com.miniapp.countryside.vo.SuccessVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SongService {
    List<SongDto>list();

    SongDto create(SongCreateRequest songCreateRequest);

    SuccessVo delete(String id);

    List<SongDto> search(String searchContent);
//    Page<SongDto> search(Pageable pageable);
}
