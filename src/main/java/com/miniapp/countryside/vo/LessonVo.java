package com.miniapp.countryside.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class LessonVo extends FileBaseVo{
    private String title;

    private String classification;

    private String teacherName;

    private String keyWords;

    private String picUrl;

    private Boolean checked;
}
