package com.miniapp.countryside.vo;

import lombok.Data;


@Data
public class SongVo extends FileBaseVo{
    private String songName;

    private String singerName;

    private String songUrl;

    private String songPicUrl;
}
