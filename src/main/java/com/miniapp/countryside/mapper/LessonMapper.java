package com.miniapp.countryside.mapper;

import com.miniapp.countryside.dto.LessonCreateRequest;
import com.miniapp.countryside.dto.LessonDto;
import com.miniapp.countryside.entity.Lesson;
import com.miniapp.countryside.vo.LessonVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface LessonMapper {
    LessonDto toDto(Lesson lesson);

    LessonVo toVo(LessonDto lessonDto);

    Lesson createEntity(LessonCreateRequest lessonCreateRequest);
}
