package com.yuanbao.record.mbp.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class ProductApply implements Serializable {
    static final Long serialVersionUID = 1L;
    private Long id;
    private String productTitle;
    private String productSkusTitle;
    private Integer productNumber;
    private String productDetail;
    private String productState;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Boolean deleted;
}
