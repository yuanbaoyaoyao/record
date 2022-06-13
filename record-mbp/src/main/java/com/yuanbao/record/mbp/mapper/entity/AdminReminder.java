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
    private Long productSkusId;
    private Boolean isRead;
    private String userName;
    private String orderSn;
    private String productSkusTitle;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean deleted;
}
