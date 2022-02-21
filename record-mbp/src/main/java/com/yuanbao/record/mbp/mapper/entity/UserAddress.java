package com.yuanbao.record.mbp.mapper.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserAddress implements Serializable {
    static final Long serialVersionUID = 1L;
    private Long id;
    private Integer userId;
    private String addressDetail;
    private String name;
    private String phone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean deleted;
}
