package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserFeedbackVo {
    private Long id;
    private Integer userId;
    private String username;
    private String feedbackTitle;
    private String feedbackPicUrl;
    private String feedbackContent;
    private Boolean isRead;
    private Boolean isFinished;
    private LocalDateTime createdAt;
}
