package com.miniapp.countryside.dto;

import lombok.Data;

import java.util.List;

@Data
public class SurroundingCreateRequest {

    private String creatorName;

    private String creatorPicUrl;

    private String title;

    private List<String> contentUrls;
}
