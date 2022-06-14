package com.miniapp.countryside.dto;

import lombok.Data;

@Data
public class LessonContentDto extends FileBaseDto{
    private String lessonId;

    private String contentUrl;
}
