package com.miniapp.countryside.mapper;

import com.miniapp.countryside.dto.NewsCreateRequest;
import com.miniapp.countryside.dto.NewsDto;
import com.miniapp.countryside.entity.News;
import com.miniapp.countryside.vo.NewsVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface NewsMapper {
    NewsDto toDto(News news);

    NewsVo toVo(NewsDto newsDto);

    News createEntity(NewsCreateRequest newsCreateRequest);
}
