package com.miniapp.countryside.dto;

import lombok.Data;

import java.util.Date;


@Data
public class NewsDto extends FileBaseDto{
    private String creatorName;

    private String title;

    private  String keyWords;

    private  String picUrl;

    private  String content;
}
