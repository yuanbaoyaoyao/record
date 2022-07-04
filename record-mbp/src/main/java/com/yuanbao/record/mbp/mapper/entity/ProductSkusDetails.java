package com.yuanbao.record.mbp.mapper.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductSkusDetails {
    static final Long serialVersionUID = 1L;
    private Long id;
    private Long productId;
    private String avatar;
    private Integer sequence;
    private LocalDateTime createdAt;
    private LocalDateTime Date;
    private Boolean deleted;
}
