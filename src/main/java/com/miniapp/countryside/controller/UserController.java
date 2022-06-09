package com.miniapp.countryside.controller;

import com.miniapp.countryside.dto.UserCreateRequest;
import com.miniapp.countryside.dto.UserLoginRequest;
import com.miniapp.countryside.mapper.UserMapper;
import com.miniapp.countryside.service.UserServise;
import com.miniapp.countryside.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")

public class UserController {

    UserServise userServise;

//    @Autowired
    UserMapper userMapper;

    @GetMapping("")
    List<UserVo>list(){
        return userServise.list().stream().map(userMapper::toVo).collect(Collectors.toList());
    }

    @PostMapping("")
    UserVo create(@Validated @RequestBody UserCreateRequest userCreateRequest){
        return userMapper.toVo(userServise.create(userCreateRequest));
    }

    @PostMapping("/login")
    String login(@Validated @RequestBody UserLoginRequest userLoginRequest){
        return userServise.login(userLoginRequest);
    }

    @Autowired
    public void setUserServise(UserServise userServise) {
        this.userServise = userServise;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
