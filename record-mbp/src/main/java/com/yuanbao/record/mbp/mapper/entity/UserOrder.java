package com.yuanbao.record.mbp.mapper.entity;

import com.yuanbao.record.mbp.vo.OrderProductVo;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserOrder implements Serializable {
    static final Long serialVersionUID = 1L;
    private Long id;
    private Long userId;
    private Long userAddressId;
    private String receiver;
    private String user;
    private String addressDetail;
    //    private Integer countOrderNumber;
//    private Integer sumProductNumber;
    private Long orderSn;
    private Integer orderStatus;
    private String orderRemarks;
    private List<OrderProductVo> orderProductVoList;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean deleted;
}
