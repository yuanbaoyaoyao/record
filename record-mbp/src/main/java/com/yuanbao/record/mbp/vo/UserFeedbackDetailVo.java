package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserFeedbackDetailVo {
    private Long id;
    private Long userFeedbackId;
    private Long adminUserId;
    private String adminUserName;
    private String content;
    private LocalDateTime createdAt;
}
