package com.miniapp.countryside.dto;

import lombok.Data;

import java.util.Date;

@Data
public class VideoDto extends FileBaseDto{
    private String creatorName;

    private String creatorPicUrl;

    private String title;

    private  String videoUrl;

    private Integer likeNum;
}
