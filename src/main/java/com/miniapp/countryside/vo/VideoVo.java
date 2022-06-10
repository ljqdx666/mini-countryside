package com.miniapp.countryside.vo;

import lombok.Data;


@Data
public class VideoVo extends FileBaseVo{
    private String creatorName;

    private String creatorPicUrl;

    private String title;

    private  String videoUrl;

    private Integer likeNum;
}
