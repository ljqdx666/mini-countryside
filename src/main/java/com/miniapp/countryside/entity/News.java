package com.miniapp.countryside.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class News extends FileBaseEntity {
    @Column(unique = true)
    private String title;

    @Column(name="key_words")
    private  String keyWords;

    @Column(name="pic_url")
    private  String picUrl;

    private  String content;

    @Column(name="creator_name")
    private String creatorName;
}
