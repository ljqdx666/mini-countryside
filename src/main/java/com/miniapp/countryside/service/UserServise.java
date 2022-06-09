package com.miniapp.countryside.service;

import com.miniapp.countryside.dto.UserCreateRequest;
import com.miniapp.countryside.dto.UserDto;
import com.miniapp.countryside.dto.UserLoginRequest;

import java.util.List;

public interface UserServise {
    List<UserDto>list();

    UserDto create(UserCreateRequest userCreateRequest);

    String login(UserLoginRequest userLoginRequest);
}
