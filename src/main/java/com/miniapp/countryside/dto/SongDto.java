package com.miniapp.countryside.dto;

import lombok.Data;


@Data
public class SongDto extends FileBaseDto{

    private String songName;

    private String singerName;

    private String songUrl;

    private String songPicUrl;
}
