package com.miniapp.countryside.service.impl;

import com.miniapp.countryside.entity.User;
import com.miniapp.countryside.exception.BizException;
import com.miniapp.countryside.exception.ExceptionType;
import com.miniapp.countryside.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public abstract class BaseService {
    private UserRepository userRepository;


//    protected User getCurrentUserEntity() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        // todo
//        return loadUserByUsername(authentication.getName());
//    }

    protected User loadUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        return user.get();
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
