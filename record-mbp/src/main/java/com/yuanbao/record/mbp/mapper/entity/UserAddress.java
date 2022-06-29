package com.yuanbao.record.mbp.mapper.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserAddress implements Serializable {
    static final Long serialVersionUID = 1L;
    private Long id;
    private Long userId;
    private String addressDetail;
    private String receiver;
    private String user;
    private String phone;
    private Boolean isDefault;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean deleted;
}
