package com.yuanbao.record.mbp.mapper.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ProductApply implements Serializable {
    static final Long serialVersionUID = 1L;
    private Long id;
    private Long userId;
    private String productTitle;
    private String productSkusTitle;
    private Integer productNumber;
    private String productDetail;
    private String productState;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean deleted;
}
