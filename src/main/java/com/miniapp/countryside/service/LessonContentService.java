package com.miniapp.countryside.service;

import com.miniapp.countryside.dto.LessonContentDto;

import java.util.List;

public interface LessonContentService {
    List<LessonContentDto>list(String lessonId);

//    LessonContentDto create(String lessonId,String contentUrl);

    void create(String lessonId,String contentUrl);


    void delete(String lessonId);

//    List<LessonContentDto> search(String searchContent);
}
