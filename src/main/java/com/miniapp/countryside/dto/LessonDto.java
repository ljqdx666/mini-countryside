package com.miniapp.countryside.dto;

import lombok.Data;


@Data
public class LessonDto extends FileBaseDto{
    private String title;

    private String teacherName;

    private String keyWords;

    private Boolean checked;
}
