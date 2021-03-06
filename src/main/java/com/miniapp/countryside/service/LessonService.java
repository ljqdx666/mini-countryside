package com.miniapp.countryside.service;

import com.miniapp.countryside.dto.LessonCreateRequest;
import com.miniapp.countryside.dto.LessonDto;
import com.miniapp.countryside.vo.SuccessVo;

import java.util.List;

public interface LessonService {
    List<LessonDto>listUnchecked();

    List<LessonDto>listPassed();

    List<LessonDto>listClass(String classification);

    LessonDto create(LessonCreateRequest lessonCreateRequest);

    SuccessVo delete(String id);

    List<LessonDto> search(String searchContent);

    LessonDto changeToPassed(String id);
}
