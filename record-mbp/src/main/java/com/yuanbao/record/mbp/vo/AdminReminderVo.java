package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdminReminderVo {
    private Long id;
    private Long userFeedbackId;
    private Long orderProductId;
    private Long productSKusId;
    private Boolean isRead;
    private LocalDateTime createdAt;
}
