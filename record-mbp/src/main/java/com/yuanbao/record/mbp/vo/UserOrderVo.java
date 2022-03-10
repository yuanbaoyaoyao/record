package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserOrderVo {
    private Long userId;
    private Long userAddressId;
    private String productTitle;
    private String productSkusTitle;
    private String receiver;
    private String user;
    private String addressDetail;
    private Integer productNumber;
    private Long orderSn;
    private Integer orderStatus;
    private String orderRemarks;
    private LocalDateTime createdAt;
}
