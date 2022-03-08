package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserOrderVo {
    private Integer userId;
    private Integer userAddressId;
    private String productTitle;
    private String productSkusTitle;
    private Integer productNumber;
    private String orderSn;
    private String orderStatus;
    private String orderRemarks;
    private LocalDateTime createdAt;
}
