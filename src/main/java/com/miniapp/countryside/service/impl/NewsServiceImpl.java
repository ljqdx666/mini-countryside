package com.miniapp.countryside.service.impl;

import com.miniapp.countryside.dto.NewsCreateRequest;
import com.miniapp.countryside.dto.NewsDto;
import com.miniapp.countryside.entity.News;
import com.miniapp.countryside.mapper.NewsMapper;
import com.miniapp.countryside.repository.NewsRepository;
import com.miniapp.countryside.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl extends BaseService implements NewsService {

    NewsRepository newsRepository;
    NewsMapper newsMapper;

    @Override
    public List<NewsDto> list() {
        return newsRepository.findAll().stream().map(newsMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public NewsDto create(NewsCreateRequest newsCreateRequest) {
        News news=newsMapper.createEntity(newsCreateRequest);
        return  newsMapper.toDto(newsRepository.save(news));
    }

    @Autowired
    public void setNewsRepository(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Autowired
    public void setNewsMapper(NewsMapper newsMapper) {
        this.newsMapper = newsMapper;
    }
}
