package com.miniapp.countryside.mapper;

import com.miniapp.countryside.dto.LessonContentDto;
import com.miniapp.countryside.entity.LessonContent;
import com.miniapp.countryside.vo.LessonContentVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface LessonContentMapper {
    LessonContentDto toDto(LessonContent lessonContent);

    LessonContentVo toVo(LessonContentDto lessonContentDto);

//    LessonContent createEntity()
}
