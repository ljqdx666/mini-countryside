package com.miniapp.countryside.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class LessonCreateRequest {
    @NotBlank(message = "课程名称不能为空")
    private String title;

    @NotBlank(message = "主讲人姓名不能为空")
    private String teacherName;

    private String keyWords;

//    @NotBlank(message = "课程内容不能为空")
    private List<String> contentUrls;
}
