package com.yuanbao.record.mbp.mapper.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserOrder implements Serializable {
    static final Long serialVersionUID = 1L;
    private Long id;
    private Long userId;
    private Long userAddressId;
    private String receiver;
    private String user;
    private String addressDetail;
    private String productTitle;
    private String productSkusTitle;
    private Integer productNumber;
//    private String productDetail;
    private Long orderSn;
    private Integer orderStatus;
    private String orderRemarks;
    //    private Float totalCost;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean deleted;
}
