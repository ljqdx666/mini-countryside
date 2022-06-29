package com.miniapp.countryside.controller;

import com.miniapp.countryside.dto.NewsCreateRequest;
import com.miniapp.countryside.entity.News;
import com.miniapp.countryside.mapper.NewsMapper;
import com.miniapp.countryside.service.NewsService;
import com.miniapp.countryside.vo.NewsVo;
import com.miniapp.countryside.vo.SuccessVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
//    Page<NewsVo> search(@PageableDefault (sort = {"createdTime"}, direction = Sort.Direction.DESC) Pageable pageable){
//        return newsService.search(pageable).map(newsMapper::toVo);
//    }

    @PostMapping("")
    NewsVo create(@Validated @RequestBody NewsCreateRequest newsCreateRequest){
        return newsMapper.toVo(newsService.create(newsCreateRequest));
    }

    @GetMapping("/{searchContent}")
    List<NewsVo> search(@PathVariable String searchContent){ return  newsService.search(searchContent).stream().map(newsMapper::toVo).collect(Collectors.toList());}

    @DeleteMapping("/{id}")
    SuccessVo delete(@PathVariable String id){return newsService.delete(id);}

    @Autowired
    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }

    @Autowired
    public void setNewsMapper(NewsMapper newsMapper) {
        this.newsMapper = newsMapper;
    }
}
