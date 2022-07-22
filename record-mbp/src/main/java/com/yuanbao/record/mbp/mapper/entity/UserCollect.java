package com.yuanbao.record.mbp.mapper.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserCollect implements Serializable {
    static final Long serialVersionUID = 1L;
    private Long id;
    private Long userId;
    private String avatar;
    private String title;
    private String productName;
    private Long productSkusId;
    private Integer stock;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean deleted;
}
