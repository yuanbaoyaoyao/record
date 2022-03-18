package com.yuanbao.record.mbp.mapper.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class OrderProduct implements Serializable {
    static final Long serialVersionUID = 1L;
    private Long id;
    private Long userOrderId;
    private Long productId;
    private Long productSkusId;
    private String productTitle;
    private String productSkusTitle;
    private Integer number;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean deleted;
}
