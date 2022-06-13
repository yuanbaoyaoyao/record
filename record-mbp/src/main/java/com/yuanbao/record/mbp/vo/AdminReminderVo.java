package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdminReminderVo {
    private Long id;
    private Long userFeedbackId;
    private Long orderProductId;
    private Long productSkusId;
    private Boolean isRead;
    private String userName;
    private String orderSn;
    private String productSkusTitle;
    private LocalDateTime createdAt;
}
