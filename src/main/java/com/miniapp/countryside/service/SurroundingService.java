package com.miniapp.countryside.service;

import com.miniapp.countryside.dto.SurroundingCreateRequest;
import com.miniapp.countryside.dto.SurroundingDto;
import com.miniapp.countryside.vo.SurroundingRequestVo;

import java.util.List;

public interface SurroundingService {
    List<SurroundingRequestVo> list();

    List<SurroundingRequestVo> findMine(String creatorName);

    SurroundingDto create(SurroundingCreateRequest surroundingCreateRequest);

    void delete(String id);
}
