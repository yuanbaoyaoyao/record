package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserReminderVo {
    private Long id;
    private Long userId;
    private Long userFeedbackId;
    private Long orderProductId;
    private Boolean isRead;
    private LocalDateTime createdAt;
}
