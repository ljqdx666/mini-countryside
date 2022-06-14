package com.miniapp.countryside.dto;

import lombok.Data;


@Data
public class LessonDto extends FileBaseDto{
    private String title;

    private String classification;

    private String teacherName;

    private String keyWords;

    private String picUrl;

    private Boolean checked;
}
