package com.miniapp.countryside.service.impl;

import com.miniapp.countryside.dto.NewsCreateRequest;
import com.miniapp.countryside.dto.NewsDto;
import com.miniapp.countryside.entity.News;
import com.miniapp.countryside.exception.BizException;
import com.miniapp.countryside.exception.ExceptionType;
import com.miniapp.countryside.mapper.NewsMapper;
import com.miniapp.countryside.repository.NewsRepository;
import com.miniapp.countryside.service.NewsService;
import com.miniapp.countryside.vo.SuccessVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        return newsMapper.toDto(newsRepository.save(news));
    }

    @Override
    public SuccessVo delete(String id) {
        newsRepository.delete(getById(id));
        SuccessVo successVo=new SuccessVo();
        successVo.setCode("删除成功");
        return successVo;
    }

    @Override
    public List<NewsDto> search(String searchContent) {
//        List<News> news=newsRepository.findByTitle(searchContent);
        try {
            searchContent = new String(searchContent.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List<News> news=newsRepository.findByTitleLike("%"+searchContent+"%");
//        List<News> all=newsRepository.findAll();
//        List<News> news=new ArrayList<>();
//        for (News news1: all){
//            if (news1.getTitle().indexOf(searchContent)!=-1)
//                news.add(news1);
//        }
        if (news.size()==0)
//            throw new BizException(40000,searchContent);
            throw new BizException(ExceptionType.SEARCH_NEWS_NOT_FOUND);
        return news.stream().map(newsMapper::toDto).collect(Collectors.toList());
    }

//    @Override
//    public Page<NewsDto> search(Pageable pageable) {
//        return newsRepository.findAll(pageable).map(newsMapper::toDto);
//    }

    private News getById(String id){
        Optional<News> news=newsRepository.findById(id);
        if (!news.isPresent()) {
            throw new BizException(ExceptionType.NEWS_NOT_FOUND);
        }
        return news.get();
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
