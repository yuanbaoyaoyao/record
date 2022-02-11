package com.yuanbao.record.mbp.mapper.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class Product implements Serializable {
    static final Long serialVersionUID = 1L;
    private Long id;
    private String title;
    private String description;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Boolean deleted;
}
