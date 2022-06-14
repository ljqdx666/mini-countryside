package com.miniapp.countryside.service;

import com.miniapp.countryside.dto.LessonCreateRequest;
import com.miniapp.countryside.dto.LessonDto;

import java.util.List;

public interface LessonService {
    List<LessonDto>list();

    LessonDto create(LessonCreateRequest lessonCreateRequest);

    void delete(String id);

    List<LessonDto> search(String searchContent);
}
