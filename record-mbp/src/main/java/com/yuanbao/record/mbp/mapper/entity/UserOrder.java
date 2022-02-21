package com.yuanbao.record.mbp.mapper.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserOrder implements Serializable {
    static final Long serialVersionUID = 1L;
    private Long id;
    private Integer userId;
    private Integer userAddressId;
    private String orderSn;
    private String orderStatus;
    private String orderRemarks;
    private Float totalCost;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean deleted;
}
