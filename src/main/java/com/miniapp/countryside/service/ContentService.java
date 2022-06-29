package com.miniapp.countryside.service;

import com.miniapp.countryside.dto.ContentDto;

import java.util.List;

public interface ContentService {
    List<ContentDto>list(String lessonId);

//    LessonContentDto create(String lessonId,String contentUrl);

    void create(String lessonId,String contentUrl);


    void delete(String lessonId);

//    List<LessonContentDto> search(String searchContent);
}
