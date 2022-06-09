package com.miniapp.countryside.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserCreateRequest {
    @NotBlank(message = "用户名不能为空")
    @Size(min = 3, max = 10, message = "用户名长度应该在3个字符到10个字符之间")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Size(min = 3, max = 20, message = "密码长度应该在3个字符到20个字符之间")
    private String password;
}
