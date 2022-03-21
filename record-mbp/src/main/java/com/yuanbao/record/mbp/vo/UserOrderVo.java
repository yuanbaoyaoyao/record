package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserOrderVo {
    private Long id;
    private Long userId;
    private Long userAddressId;
    private String receiver;
    private String user;
    private String addressDetail;
    private Long orderSn;
    private Integer orderStatus;
    private String orderRemarks;
    private Integer countOrderNumber;
    private Integer sumProductNumber;
    private String maxNumSkuName;
    private String timeFrame;
    private LocalDateTime createdAt;
    private List<OrderProductVo> orderProductVoList;
}
