package com.miniapp.countryside.controller;

import com.miniapp.countryside.mapper.LessonContentMapper;
import com.miniapp.countryside.service.LessonContentService;
import com.miniapp.countryside.vo.LessonContentVo;
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
    LessonContentService lessonContentService;
    LessonContentMapper lessonContentMapper;

    @GetMapping("/{lessonId}")
    List<LessonContentVo>list(@PathVariable String lessonId){return lessonContentService.list(lessonId).stream().map(lessonContentMapper::toVo).collect(Collectors.toList());}

    @Autowired
    public void setLessonContentService(LessonContentService lessonContentService) {
        this.lessonContentService = lessonContentService;
    }

    @Autowired
    public void setLessonContentMapper(LessonContentMapper lessonContentMapper) {
        this.lessonContentMapper = lessonContentMapper;
    }
}
