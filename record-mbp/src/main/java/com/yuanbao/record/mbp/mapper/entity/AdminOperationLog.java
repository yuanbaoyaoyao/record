package com.yuanbao.record.mbp.mapper.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AdminOperationLog implements Serializable {
    static final Long serialVersionUID = 1L;
    private Long id;
    private String ip;
    private String action;
    private String adminUserName;
    private String menu;
    private String result;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean deleted;
}
