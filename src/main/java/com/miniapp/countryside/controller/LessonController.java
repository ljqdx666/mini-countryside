package com.miniapp.countryside.controller;

import com.miniapp.countryside.dto.LessonCreateRequest;
import com.miniapp.countryside.mapper.LessonMapper;
import com.miniapp.countryside.service.LessonService;
import com.miniapp.countryside.vo.LessonVo;
import com.miniapp.countryside.vo.SuccessVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/lesson")
public class LessonController {
    LessonService lessonService;
    LessonMapper lessonMapper;

    @GetMapping("")
    List<LessonVo>listPassed(){return lessonService.listPassed().stream().map(lessonMapper::toVo).collect(Collectors.toList());}

    @GetMapping("/unchecked")
    List<LessonVo>listUnchecked(){return lessonService.listUnchecked().stream().map(lessonMapper::toVo).collect(Collectors.toList());}

    @PostMapping("")
    LessonVo create(@Validated @RequestBody LessonCreateRequest lessonCreateRequest){
        return lessonMapper.toVo(lessonService.create(lessonCreateRequest));
    }

    @GetMapping("/{searchContent}")
    List<LessonVo> search(@PathVariable String searchContent){return lessonService.search(searchContent).stream().map(lessonMapper::toVo).collect(Collectors.toList());}

    @DeleteMapping("/{id}")
    SuccessVo delete(@PathVariable String id){return lessonService.delete(id);}

    @GetMapping("/pass/{id}")
    LessonVo changeToPassed(@PathVariable String id){return lessonMapper.toVo(lessonService.changeToPassed(id));}

    @GetMapping("/class/{classification}")
    List<LessonVo> listClass(@PathVariable String classification){return lessonService.listClass(classification).stream().map(lessonMapper::toVo).collect(Collectors.toList());}

    @Autowired
    public void setLessonService(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @Autowired
    public void setLessonMapper(LessonMapper lessonMapper) {
        this.lessonMapper = lessonMapper;
    }
}
