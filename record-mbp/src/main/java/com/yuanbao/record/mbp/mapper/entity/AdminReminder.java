package com.yuanbao.record.mbp.mapper.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AdminReminder implements Serializable {
    static final Long serialVersionUID = 1L;
    private Long id;
    private Long userFeedbackId;
    private Long orderProductId;
    private Long productSKusId;
    private Boolean isRead;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean deleted;
}