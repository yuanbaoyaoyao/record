package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserCollectVo {
    private Long id;
    private String avatar;
    private String title;
    private String productName;
    private Long productSkusId;
    private String description;
    private Integer stock;
    private LocalDateTime createdAt;
}
