package com.miniapp.countryside.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SurroundingRequestVo extends FileBaseVo{
    private String creatorName;

    private String creatorPicUrl;

    private String title;

    private List<String> contentUrls=new ArrayList<String>() ;
}
