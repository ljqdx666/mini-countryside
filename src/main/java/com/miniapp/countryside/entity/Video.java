package com.miniapp.countryside.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class Video extends FileBaseEntity{
    @Column(name="creator_name")
    private String creatorName;

    @Column(name="creator_pic_url")
    private String creatorPicUrl;

    @Column(unique = true)
    private String title;

    @Column(name="video_url")
    private  String videoUrl;

    @Column(name="like_num")
    private Integer likeNum;
}
