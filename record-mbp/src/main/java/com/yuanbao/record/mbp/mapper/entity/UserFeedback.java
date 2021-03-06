package com.yuanbao.record.mbp.mapper.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserFeedback implements Serializable {
    static final Long serialVersionUID = 1L;
    private Long id;
    private Integer userId;
    private String username;
    private String feedbackTitle;
    private String feedbackPicUrl;
    private String feedbackContent;
    private Boolean isRead;
    private Boolean isFinished;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean deleted;
}
