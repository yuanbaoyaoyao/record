package com.yuanbao.record.search.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EsProductSkusVo {
    private Long id;
    private String productName;
    private Long productId;
    private String title;
    private String avatar;
    private String description;
    private Integer stock;
    private LocalDateTime createdAt;
}
