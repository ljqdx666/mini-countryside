package com.miniapp.countryside.mapper;

import com.miniapp.countryside.dto.TeacherDto;
import com.miniapp.countryside.entity.Teacher;
import com.miniapp.countryside.vo.TeacherVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository
@Mapper(componentModel = "spring")
@Component
public interface TeacherMapper {
    TeacherDto toDto(Teacher teacher);

    TeacherVo toVo(TeacherDto teacherDto);
}
