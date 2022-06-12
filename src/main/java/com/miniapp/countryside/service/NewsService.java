package com.miniapp.countryside.service;

import com.miniapp.countryside.dto.NewsCreateRequest;
import com.miniapp.countryside.dto.NewsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewsService {
    List<NewsDto>list();

    NewsDto create(NewsCreateRequest newsCreateRequest);

    void delete(String id);

//    Page<NewsDto> search(Pageable pageable);

    List<NewsDto> search(String searchContent);
//    NewsDto get(String id);
}
