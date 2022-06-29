package com.miniapp.countryside.service.impl;

import com.miniapp.countryside.dto.ContentDto;
import com.miniapp.countryside.entity.Content;
import com.miniapp.countryside.mapper.ContentMapper;
import com.miniapp.countryside.repository.ContentRepository;
import com.miniapp.countryside.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContentServiceImpl extends BaseService implements ContentService {

    ContentRepository lessonContentRepository;
    ContentMapper lessonContentMapper;

    @Override
    public List<ContentDto> list(String lessonId) {
        return lessonContentRepository.findByLessonId(lessonId).stream().map(lessonContentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void create(String lessonId, String contentUrl) {
        Content lessonContent=new Content(lessonId,contentUrl);
//        LessonContent lessonContent=lessonContentMapper.
        lessonContentRepository.save(lessonContent);
    }

    @Override
    public void delete(String lessonId) { lessonContentRepository.deleteAllByLessonId(lessonId); }

    @Autowired
    public void setLessonContentRepository(ContentRepository lessonContentRepository) {
        this.lessonContentRepository = lessonContentRepository;
    }

    @Autowired
    public void setLessonContentMapper(ContentMapper lessonContentMapper) {
        this.lessonContentMapper = lessonContentMapper;
    }
}
