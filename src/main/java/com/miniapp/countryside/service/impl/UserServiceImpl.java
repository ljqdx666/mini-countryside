package com.miniapp.countryside.service.impl;

import com.miniapp.countryside.dto.UserCreateRequest;
import com.miniapp.countryside.dto.UserDto;
import com.miniapp.countryside.dto.UserLoginRequest;
import com.miniapp.countryside.entity.User;
import com.miniapp.countryside.exception.BizException;
import com.miniapp.countryside.exception.ExceptionType;
import com.miniapp.countryside.mapper.UserMapper;
import com.miniapp.countryside.repository.UserRepository;
import com.miniapp.countryside.service.UserServise;
import com.miniapp.countryside.vo.SuccessVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends BaseService implements UserServise {

    UserRepository repository;

    UserMapper mapper;

    @Override
    public List<UserDto> list() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto create(UserCreateRequest userCreateRequest) {
        checkUserName(userCreateRequest.getUsername());
        User user = mapper.createEntity(userCreateRequest);
        return mapper.toDto(repository.save(user));
    }

    @Override
    public SuccessVo login(UserLoginRequest userLoginRequest) {
        checkLogin(userLoginRequest);
        SuccessVo successVo=new SuccessVo();
        successVo.setCode("登陆成功");
        return successVo;
    }

    private  void checkUserName(String username){
        Optional<User> user=repository.findByUsername(username);
        if (user.isPresent()){
            throw new BizException(ExceptionType.USER_NAME_DUPLICATE);
        }
    }

    private  void checkLogin(UserLoginRequest userLoginRequest){
        String username=userLoginRequest.getUsername();
        String password=userLoginRequest.getPassword();
        Optional<User> user=repository.findByUsername(username);
        if(!user.isPresent() || !user.get().getPassword().equals(password)){
            throw new BizException(ExceptionType.USER_PASSWORD_NOT_MATCH);
        }
    }

    @Override
    public User loadUserByUsername(String username) {
        return super.loadUserByUsername(username);
    }

    @Autowired
    private void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @Autowired
    private void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }
}
