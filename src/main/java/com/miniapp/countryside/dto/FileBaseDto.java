package com.miniapp.countryside.dto;

import lombok.Data;

import java.util.Date;

@Data
public abstract class FileBaseDto {
    private String id;

    private Date createdTime;

    private Date updatedTime;
}
