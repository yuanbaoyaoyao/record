package com.yuanbao.record.mbp.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class UserCollect implements Serializable {
    static final Long serialVersionUID = 1L;
    private Long id;
    private Integer userId;
    private Integer productId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Boolean deleted;
}
