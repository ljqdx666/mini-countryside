package com.miniapp.countryside.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Lesson extends FileBaseEntity{

    private String title;

    @Column(name = "teacher_name")
    private String teacherName;

    @Column(name = "key_words")
    private String keyWords;

    private Boolean checked=false;
}
