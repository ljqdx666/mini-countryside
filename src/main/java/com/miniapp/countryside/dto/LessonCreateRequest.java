package com.miniapp.countryside.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class LessonCreateRequest {
    @NotBlank(message = "课程名称不能为空")
//    @JsonProperty(value = "title")
    private String title;

    @NotBlank(message = "分类不能为空")
    private String classification;

    @NotBlank(message = "主讲人姓名不能为空")
    @JsonProperty(value = "teacherName")
    private String teacherName;

    private String keyWords;

    @NotBlank(message = "封面图片不能为空")
//    @JsonProperty(value = "picurl")
    private String picUrl;

//    @NotBlank(message = "课程内容不能为空")
    private List<String> contentUrls;
}
