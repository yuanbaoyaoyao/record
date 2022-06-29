package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CartVo {
    private Long id;
    private Long userId;
    private Long productSkusId;
    private Integer productSkusNumber;
    private String avatar;
    private String title;
    private String productName;
    private Integer stock;
    private LocalDateTime createdAt;
}
