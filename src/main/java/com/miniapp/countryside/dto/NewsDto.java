package com.miniapp.countryside.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


@Data
public class NewsDto {
    private String id;

    private String creatorName;

    private String title;

    private  String keyWords;

    private  String picUrl;

    private  String content;

    private Date createdTime;

    private Date updatedTime;
}
