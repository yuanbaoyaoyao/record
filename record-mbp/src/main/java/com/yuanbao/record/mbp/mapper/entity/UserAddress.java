package com.yuanbao.record.mbp.mapper.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class UserAddress implements Serializable {
    static final Long serialVersionUID = 1L;
    private Long id;
    private Integer userId;
    private String addressDetail;
    private String name;
    private String phone;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Boolean deleted;
}
