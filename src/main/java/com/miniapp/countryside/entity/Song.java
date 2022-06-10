package com.miniapp.countryside.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class Song extends FileBaseEntity{
    @Column(name="song_name")
    private String songName;

    @Column(name="singer_name")
    private String singerName;

    @Column(name="song_url")
    private String songUrl;

    @Column(name="song_pic_url")
    private String songPicUrl;
}
