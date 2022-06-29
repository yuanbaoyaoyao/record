package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductVo {
    private Long id;
    private String title;
    private String avatar;
    private String description;
    private Integer type;
    private LocalDateTime createdAt;
}
