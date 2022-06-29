package com.miniapp.countryside.mapper;

import com.miniapp.countryside.dto.ContentDto;
import com.miniapp.countryside.entity.Content;
import com.miniapp.countryside.vo.ContentVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ContentMapper {
    ContentDto toDto(Content Content);

    ContentVo toVo(ContentDto contentDto);

//    LessonContent createEntity()
}
