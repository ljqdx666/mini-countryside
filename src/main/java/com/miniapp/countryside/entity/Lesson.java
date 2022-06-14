package com.miniapp.countryside.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Lesson {

    @Id
    @GeneratedValue(generator = "ksuid")
    @GenericGenerator(name = "ksuid", strategy = "com.miniapp.countryside.utils.KsuidIdentifierGenerator")
//    @GeneratedValue
    private String id;

    @CreationTimestamp
    @Column(name = "created_time")
    private Date createdTime;

    @UpdateTimestamp
    @Column(name = "updated_time")
    private Date updatedTime;

    private String title;

    @Column(name = "classification")
    private String classification;

    @Column(name = "teacher_name")
    private String teacherName;

    @Column(name = "key_words")
    private String keyWords;

    @Column(name = "pic_url")
    private String picUrl;

    private Boolean checked=false;
}
