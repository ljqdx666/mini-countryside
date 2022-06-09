package com.miniapp.countryside.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class NewsCreateRequest {

    @NotBlank(message = "标题不能为空")
    @Size(min = 2, max = 20, message = "标题长度应该在2个字符到20个字符之间")
    private String title;

    @Size(max = 30, message = "标题长度应该在30个字符以内")
    private  String keyWords;

    private String creatorName;

    private  String picUrl;

    @NotBlank(message = "内容不能为空")
    private  String content;
}
