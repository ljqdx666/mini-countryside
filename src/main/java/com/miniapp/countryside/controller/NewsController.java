package com.miniapp.countryside.controller;

import com.miniapp.countryside.dto.NewsCreateRequest;
import com.miniapp.countryside.mapper.NewsMapper;
import com.miniapp.countryside.service.NewsService;
import com.miniapp.countryside.vo.NewsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/news")
public class NewsController {
    NewsService newsService;

    NewsMapper newsMapper;

    @GetMapping("")
    List<NewsVo>list(){return newsService.list().stream().map(newsMapper::toVo).collect(Collectors.toList());}

    @PostMapping("")
    NewsVo create(@Validated @RequestBody NewsCreateRequest newsCreateRequest){
        return newsMapper.toVo(newsService.create(newsCreateRequest));
    }

    @Autowired
    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }

    @Autowired
    public void setNewsMapper(NewsMapper newsMapper) {
        this.newsMapper = newsMapper;
    }
}
