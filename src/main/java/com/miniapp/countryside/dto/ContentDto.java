package com.miniapp.countryside.dto;

import lombok.Data;

@Data
public class ContentDto extends FileBaseDto{
    private String lessonId;

    private String contentUrl;
}
