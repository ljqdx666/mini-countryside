package com.miniapp.countryside.controller;

import com.miniapp.countryside.mapper.ContentMapper;
import com.miniapp.countryside.service.ContentService;
import com.miniapp.countryside.vo.ContentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/lesson/content")
public class LessonContentController {
    ContentService lessonContentService;
    ContentMapper lessonContentMapper;

    @GetMapping("/{lessonId}")
    List<ContentVo>list(@PathVariable String lessonId){return lessonContentService.list(lessonId).stream().map(lessonContentMapper::toVo).collect(Collectors.toList());}

    @Autowired
    public void setLessonContentService(ContentService lessonContentService) {
        this.lessonContentService = lessonContentService;
    }

    @Autowired
    public void setLessonContentMapper(ContentMapper lessonContentMapper) {
        this.lessonContentMapper = lessonContentMapper;
    }
}
