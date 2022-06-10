package com.miniapp.countryside.mapper;

import com.miniapp.countryside.dto.UserCreateRequest;
import com.miniapp.countryside.dto.UserDto;
import com.miniapp.countryside.entity.User;
import com.miniapp.countryside.vo.UserVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
//@Repository
@Component
public interface UserMapper {
    UserDto toDto(User user);

    UserVo toVo(UserDto userDto);

    User createEntity(UserCreateRequest userCreateRequest);
}