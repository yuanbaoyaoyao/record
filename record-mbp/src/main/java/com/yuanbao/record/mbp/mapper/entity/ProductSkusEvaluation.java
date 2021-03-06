package com.yuanbao.record.mbp.mapper.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductSkusEvaluation {
    static final Long serialVersionUID = 1L;
    private Long id;
    private Long orderProductId;
    private String productSkusEvaluation;
    private String additionalEvaluation;
    private Long orderSn;
    private Long productSkusId;
    private String productTitle;
    private String productSkusTitle;
    private Integer number;
    private String receiver;
    private String avatar;
    private LocalDateTime createdAt;
    private LocalDateTime Date;
    private Boolean deleted;
}
