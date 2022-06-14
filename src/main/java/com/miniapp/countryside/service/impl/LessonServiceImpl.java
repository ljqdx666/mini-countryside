package com.miniapp.countryside.service.impl;

import com.miniapp.countryside.dto.LessonCreateRequest;
import com.miniapp.countryside.dto.LessonDto;
import com.miniapp.countryside.entity.Lesson;
import com.miniapp.countryside.exception.BizException;
import com.miniapp.countryside.exception.ExceptionType;
import com.miniapp.countryside.mapper.LessonContentMapper;
import com.miniapp.countryside.mapper.LessonMapper;
import com.miniapp.countryside.repository.LessonContentRepository;
import com.miniapp.countryside.repository.LessonRepository;
import com.miniapp.countryside.service.LessonContentService;
import com.miniapp.countryside.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class LessonServiceImpl extends BaseService implements LessonService {

    LessonRepository lessonRepository;
    LessonMapper lessonMapper;
    LessonContentRepository lessonContentRepository;
    LessonContentMapper lessonContentMapper;
    LessonContentService lessonContentService;

    @Override
    public List<LessonDto> list() {
        return lessonRepository.findAll().stream().map(lessonMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public LessonDto create(LessonCreateRequest lessonCreateRequest) {
        Lesson lesson=lessonMapper.createEntity(lessonCreateRequest);
        checkLessonUnique(lessonCreateRequest.getTitle(),lessonCreateRequest.getTeacherName());
        Lesson savedLesson=lessonRepository.save(lesson);
        String lessonId=savedLesson.getId();
        List<String> contents=lessonCreateRequest.getContentUrls();
        for (String content:contents){
            lessonContentService.create(lessonId,content);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
//        System.out.println(savedLesson.toString());
        return lessonMapper.toDto(savedLesson);
//        return lessonMapper.toDto(lessonRepository.save(lesson));
    }

    @Override
    public void delete(String id) {
        lessonRepository.delete(getById(id));
        lessonContentRepository.deleteAllByLessonId(id);
    }

    @Override
    public List<LessonDto> search(String searchContent) {
        try {
            searchContent = new String(searchContent.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List<Lesson> lessons=lessonRepository.findByTitleLike("%"+searchContent+"%");
        if (lessons.size()==0)
            throw new BizException(ExceptionType.SEARCH_LESSON_NOT_FOUND);
        return lessons.stream().map(lessonMapper::toDto).collect(Collectors.toList());
    }

    private Lesson getById(String id){
        Optional<Lesson> lesson=lessonRepository.findById(id);
        if (!lesson.isPresent()){
            throw new BizException(ExceptionType.LESSON_NOT_FOUND);
        }
        return lesson.get();
    }

    private void checkLessonUnique(String title,String teacherName){
        Optional<Lesson> lesson=lessonRepository.findByTitleAndTeacherName(title,teacherName);
        if (lesson.isPresent()){
            throw new BizException(ExceptionType.LESSON_DUPLICATE);
        }
    }

    @Autowired
    public void setLessonRepository(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Autowired
    public void setLessonMapper(LessonMapper lessonMapper) {
        this.lessonMapper = lessonMapper;
    }

    @Autowired
    public void setLessonContentRepository(LessonContentRepository lessonContentRepository) {
        this.lessonContentRepository = lessonContentRepository;
    }

    @Autowired
    public void setLessonContentMapper(LessonContentMapper lessonContentMapper) {
        this.lessonContentMapper = lessonContentMapper;
    }

    @Autowired
    public void setLessonContentService(LessonContentService lessonContentService) {
        this.lessonContentService = lessonContentService;
    }
}
