package com.miniapp.countryside.service;

import com.miniapp.countryside.dto.SurroundingCreateRequest;
import com.miniapp.countryside.dto.SurroundingDto;

import java.util.List;

public interface SurroundingService {
    List<SurroundingDto> list();

    List<SurroundingDto> findMine(String creatorName);

    SurroundingDto create(SurroundingCreateRequest surroundingCreateRequest);

    void delete(String id);
}
