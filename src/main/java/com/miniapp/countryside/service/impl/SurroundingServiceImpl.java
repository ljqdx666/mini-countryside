package com.miniapp.countryside.service.impl;

import com.miniapp.countryside.dto.SurroundingCreateRequest;
import com.miniapp.countryside.dto.SurroundingDto;
import com.miniapp.countryside.entity.Content;
import com.miniapp.countryside.entity.Surrounding;
import com.miniapp.countryside.exception.BizException;
import com.miniapp.countryside.exception.ExceptionType;
import com.miniapp.countryside.mapper.ContentMapper;
import com.miniapp.countryside.mapper.SurroundingMapper;
import com.miniapp.countryside.repository.ContentRepository;
import com.miniapp.countryside.repository.SurroundingRepository;
import com.miniapp.countryside.service.ContentService;
import com.miniapp.countryside.service.SurroundingService;
import com.miniapp.countryside.vo.SuccessVo;
import com.miniapp.countryside.vo.SurroundingRequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SurroundingServiceImpl extends BaseService implements SurroundingService {
    SurroundingRepository surroundingRepository;
    SurroundingMapper surroundingMapper;
    ContentRepository surroundingContentRepository;
    ContentMapper surroundingContentMapper;
    ContentService surroundingContentService;

    @Override
    public List<SurroundingRequestVo> list() {
        List<Surrounding> surroundings=surroundingRepository.findAll();
//        return surroundings.stream().map(surroundingMapper::toDto).collect(Collectors.toList());
        return addContents(surroundings);
//        return surroundingRepository.findAll().stream().map(surroundingMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<SurroundingRequestVo> findMine(String creatorName) {
        try {
            creatorName = new String(creatorName.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List<Surrounding> surroundings=surroundingRepository.getAllByCreatorName(creatorName);
        if (surroundings.size()==0){
            throw new BizException(ExceptionType.NO_MINE_SURROUNDING);
        }
//        return surroundings.stream().map(surroundingMapper::toDto).collect(Collectors.toList());
        return addContents(surroundings);
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
    public SuccessVo delete(String id) {
        surroundingRepository.delete(getById(id));
        surroundingContentRepository.deleteAllByLessonId(id);
        SuccessVo successVo=new SuccessVo();
        successVo.setCode("删除成功");
        return successVo;
    }

    private Surrounding getById(String id){
        Optional<Surrounding> surrounding=surroundingRepository.findById(id);
        if (!surrounding.isPresent()){
            throw new BizException(ExceptionType.SURROUNDING_NOT_FOUND);
        }
        return surrounding.get();
    }

    private List<SurroundingRequestVo> addContents(List<Surrounding> surroundings){
        List<SurroundingRequestVo> surroundingRequestVos=new ArrayList<>();
        for (Surrounding surrounding:surroundings){
            List<String> contentUrls=new ArrayList<String>() ;
            String id=surrounding.getId();
            List<Content> lessonContents=surroundingContentRepository.findByLessonId(id);
            for (Content lessonContent:lessonContents){
                contentUrls.add(lessonContent.getContentUrl());
            }
            SurroundingRequestVo surroundingRequestVo=surroundingMapper.toRequestVo(surrounding);
            surroundingRequestVo.setContentUrls(contentUrls);
            surroundingRequestVos.add(surroundingRequestVo);
        }
        return surroundingRequestVos;
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
    public void setSurroundingContentRepository(ContentRepository surroundingContentRepository) {
        this.surroundingContentRepository = surroundingContentRepository;
    }

    @Autowired
    public void setSurroundingContentMapper(ContentMapper surroundingContentMapper) {
        this.surroundingContentMapper = surroundingContentMapper;
    }

    @Autowired
    public void setSurroundingContentService(ContentService surroundingContentService) {
        this.surroundingContentService = surroundingContentService;
    }
}
