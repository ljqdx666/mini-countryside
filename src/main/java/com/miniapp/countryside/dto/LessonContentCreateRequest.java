package com.miniapp.countryside.dto;

import javax.validation.constraints.NotBlank;

public class LessonContentCreateRequest {
    @NotBlank(message = "所属课程id不能为空")
    private String lessonId;

    @NotBlank(message = "课程内容链接不能为空")
    private String contentUrl;
}
