package com.yuanbao.record.mbp.mapper.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class ProductSkus implements Serializable {
    static final Long serialVersionUID = 1L;
    private Long id;
    private Long productId;
    private String productName;
    private String title;
    private String avatar;
    private String description;
    private Integer stock;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Boolean deleted;
}
