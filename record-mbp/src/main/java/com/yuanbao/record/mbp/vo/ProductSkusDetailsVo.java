package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductSkusDetailsVo {
    private Long id;
    private Long productId;
    private String avatar;
    private Integer sequence;
    private LocalDateTime createdAt;
}
