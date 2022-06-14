package com.miniapp.countryside.service.impl;

import com.miniapp.countryside.dto.SurroundingCreateRequest;
import com.miniapp.countryside.dto.SurroundingDto;
import com.miniapp.countryside.entity.Surrounding;
import com.miniapp.countryside.exception.BizException;
import com.miniapp.countryside.exception.ExceptionType;
import com.miniapp.countryside.mapper.LessonContentMapper;
import com.miniapp.countryside.mapper.SurroundingMapper;
import com.miniapp.countryside.repository.LessonContentRepository;
import com.miniapp.countryside.repository.SurroundingRepository;
import com.miniapp.countryside.service.LessonContentService;
import com.miniapp.countryside.service.SurroundingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class SurroundingServiceImpl extends BaseService implements SurroundingService {
    SurroundingRepository surroundingRepository;
    SurroundingMapper surroundingMapper;
    LessonContentRepository surroundingContentRepository;
    LessonContentMapper surroundingContentMapper;
    LessonContentService surroundingContentService;

    @Override
    public List<SurroundingDto> list() {
        return surroundingRepository.findAll().stream().map(surroundingMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<SurroundingDto> findMine(String creatorName) {
        try {
            creatorName = new String(creatorName.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List<Surrounding> surroundings=surroundingRepository.getAllByCreatorName(creatorName);
        if (surroundings.size()==0){
            throw new BizException(ExceptionType.NO_MINE_SURROUNDING);
        }
        return surroundings.stream().map(surroundingMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public SurroundingDto create(SurroundingCreateRequest surroundingCreateRequest) {
        Surrounding surrounding=surroundingMapper.createEntity(surroundingCreateRequest);
        Surrounding savedSurrounding=surroundingRepository.save(surrounding);
        String surroundingId=savedSurrounding.getId();
        List<String> contents=surroundingCreateRequest.getContentUrls();
        for (String content:contents){
            surroundingContentService.create(surroundingId,content);
        }
        return surroundingMapper.toDto(savedSurrounding);
    }

    @Override
    public void delete(String id) {
        surroundingRepository.delete(getById(id));
        surroundingContentRepository.deleteAllByLessonId(id);
    }

    private Surrounding getById(String id){
        Optional<Surrounding> surrounding=surroundingRepository.findById(id);
        if (!surrounding.isPresent()){
            throw new BizException(ExceptionType.SURROUNDING_NOT_FOUND);
        }
        return surrounding.get();
    }

    @Autowired
    public void setSurroundingRepository(SurroundingRepository surroundingRepository) {
        this.surroundingRepository = surroundingRepository;
    }

    @Autowired
    public void setSurroundingMapper(SurroundingMapper surroundingMapper) {
        this.surroundingMapper = surroundingMapper;
    }

    @Autowired
    public void setSurroundingContentRepository(LessonContentRepository surroundingContentRepository) {
        this.surroundingContentRepository = surroundingContentRepository;
    }

    @Autowired
    public void setSurroundingContentMapper(LessonContentMapper surroundingContentMapper) {
        this.surroundingContentMapper = surroundingContentMapper;
    }

    @Autowired
    public void setSurroundingContentService(LessonContentService surroundingContentService) {
        this.surroundingContentService = surroundingContentService;
    }
}
