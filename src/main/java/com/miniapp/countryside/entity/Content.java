package com.miniapp.countryside.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "content")
public class Content extends FileBaseEntity{
    @Column(name = "lesson_id")
    private String lessonId;

    @Column(name = "content_url")
    private String contentUrl;


    public Content(String lessonId, String contentUrl) {
        this.lessonId=lessonId;
        this.contentUrl=contentUrl;
    }

    public Content() {

    }
}
