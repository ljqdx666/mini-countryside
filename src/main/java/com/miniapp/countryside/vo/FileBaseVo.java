package com.miniapp.countryside.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.miniapp.countryside.entity.User;
import lombok.Data;
import java.util.Date;

@Data
public abstract class FileBaseVo {
    private String id;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
    private Date createdTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
    private Date updatedTime;
}
