package com.yuanbao.record.mbp.mapper.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserReminder implements Serializable {
    static final Long serialVersionUID = 1L;
    private Long id;
    private Long userId;
    private Long userFeedbackId;
    private Long orderProductId;
    private String feedbackTitle;
    private String orderSn;
    private Boolean isRead;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean deleted;
}
