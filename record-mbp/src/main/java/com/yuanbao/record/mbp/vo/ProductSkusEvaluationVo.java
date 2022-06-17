package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductSkusEvaluationVo {
    private Long id;
    private Long orderProductId;
    private String productSkusEvaluation;
    private String orderSn;
    private Long productSkusId;
    private String productTitle;
    private String productSkusTitle;
    private LocalDateTime createdAt;
}
