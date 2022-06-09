package com.miniapp.countryside.service;

import com.miniapp.countryside.dto.NewsCreateRequest;
import com.miniapp.countryside.dto.NewsDto;
import com.miniapp.countryside.vo.NewsVo;

import java.util.List;

public interface NewsService {
    List<NewsDto>list();

    NewsDto create(NewsCreateRequest newsCreateRequest);
}
