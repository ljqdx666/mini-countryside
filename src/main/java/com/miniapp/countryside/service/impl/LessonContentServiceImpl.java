package com.miniapp.countryside.service.impl;

import com.miniapp.countryside.dto.LessonContentDto;
import com.miniapp.countryside.entity.LessonContent;
import com.miniapp.countryside.mapper.LessonContentMapper;
import com.miniapp.countryside.repository.LessonContentRepository;
import com.miniapp.countryside.service.LessonContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonContentServiceImpl extends BaseService implements LessonContentService {

    LessonContentRepository lessonContentRepository;
    LessonContentMapper lessonContentMapper;

    @Override
    public List<LessonContentDto> list(String lessonId) {
        return lessonContentRepository.findByLessonId(lessonId).stream().map(lessonContentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void create(String lessonId, String contentUrl) {
        LessonContent lessonContent=new LessonContent(lessonId,contentUrl);
//        LessonContent lessonContent=lessonContentMapper.
        lessonContentRepository.save(lessonContent);
    }

    @Override
    public void delete(String lessonId) { lessonContentRepository.deleteAllByLessonId(lessonId); }

    @Autowired
    public void setLessonContentRepository(LessonContentRepository lessonContentRepository) {
        this.lessonContentRepository = lessonContentRepository;
    }

    @Autowired
    public void setLessonContentMapper(LessonContentMapper lessonContentMapper) {
        this.lessonContentMapper = lessonContentMapper;
    }
}
