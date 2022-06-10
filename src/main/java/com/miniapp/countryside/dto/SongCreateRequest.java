package com.miniapp.countryside.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SongCreateRequest {

    @NotBlank(message = "歌曲名称不能为空")
    private String songName;

    @NotBlank(message = "歌手姓名不能为空")
    private String singerName;

    @NotBlank(message = "歌曲未上传")
    private String songUrl;

    private String songPicUrl;
}
