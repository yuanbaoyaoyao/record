package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductApplyClientVo {
    private String productTitle;
    private String productSkusTitle;
    private Integer productNumber;
    private String productDetail;
    private String productState;
    private LocalDateTime createdAt;
}
