package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderProductVo {
    private Long id;
    private Long userOrderId;
    private String receiver;
    private Long orderSn;
    private Integer orderStatus;
    private Integer countOrderNumber;
    private Integer sumProductNumber;
    private Long productId;
    private Long productSkusId;
    private String productTitle;
    private String productSkusTitle;
    private String productPicUrl;
    private Integer number;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
