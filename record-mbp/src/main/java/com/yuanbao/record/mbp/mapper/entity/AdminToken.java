package com.yuanbao.record.mbp.mapper.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AdminToken implements Serializable {
    private Long id;
    private Long adminUserId;
    private String token;
    private LocalDateTime expirationTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean deleted;
}
