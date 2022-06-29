package com.miniapp.countryside.service;

import com.miniapp.countryside.dto.UserCreateRequest;
import com.miniapp.countryside.dto.UserDto;
import com.miniapp.countryside.dto.UserLoginRequest;
import com.miniapp.countryside.vo.SuccessVo;

import java.util.List;

public interface UserServise {
    List<UserDto>list();

    UserDto create(UserCreateRequest userCreateRequest);

    SuccessVo login(UserLoginRequest userLoginRequest);
}
