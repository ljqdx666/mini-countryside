package com.miniapp.countryside.vo;

import lombok.Data;


@Data
public class NewsVo extends FileBaseVo{
    private String title;

    private  String keyWords;

    private  String picUrl;

    private  String content;

    private String creatorName;
}
