package com.yuanbao.record.mbp.mapper.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserFeedback implements Serializable {
    static final Long serialVersionUID = 1L;
    private Long id;
    private Integer userId;
    private String serviceSn;
    private Integer productApplyId;
    private String serviceTitle;
    private String serviceContent;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean deleted;
}
