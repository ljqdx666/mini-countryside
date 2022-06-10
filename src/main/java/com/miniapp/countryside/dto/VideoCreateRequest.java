package com.miniapp.countryside.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class VideoCreateRequest {
    private String creatorName;

    private String creatorPicUrl;

    private String title;

    @NotBlank(message = "视频未上传")
    private  String videoUrl;
}
