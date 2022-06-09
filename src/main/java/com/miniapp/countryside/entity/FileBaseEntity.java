package com.miniapp.countryside.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public class FileBaseEntity {
    @Id
    @GeneratedValue(generator = "ksuid")
    @GenericGenerator(name = "ksuid", strategy = "com.miniapp.countryside.utils.KsuidIdentifierGenerator")
//    @GeneratedValue
    private String id;

    @CreationTimestamp
    private Date createdTime;

    @UpdateTimestamp
    private Date updatedTime;
}
