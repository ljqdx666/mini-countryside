package com.miniapp.countryside.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class Surrounding extends FileBaseEntity{
    @Column(name = "creator_name")
    private String creatorName;

    @Column(name="creator_pic_url")
    private String creatorPicUrl;

    private String title;
}
