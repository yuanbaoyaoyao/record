package com.yuanbao.record.mbp.mapper.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserFeedbackDetail implements Serializable {
    static final Long serialVersionUID = 1L;
    private Long id;
    private Long userFeedbackId;
    private Long adminUserId;
    private String adminUserName;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean deleted;
}
