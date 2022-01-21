package com.yuanbao.record.mbp.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class ProductSkus implements Serializable {
    static final Long serialVersionUID = 1L;
    private Long id;
    private Integer productId;
    private String title;
    private String description;
    private String stock;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Boolean deleted;
}
