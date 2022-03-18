package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderProductVo {
    private Long id;
    private Long userOrderId;
    private Long productId;
    private Long productSkusId;
    private String productTitle;
    private String productSkusTitle;
    private Integer number;
    private LocalDateTime createdAt;
}
