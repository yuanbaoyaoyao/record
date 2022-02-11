package com.yuanbao.record.mbp.mapper.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

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
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Boolean deleted;
}
