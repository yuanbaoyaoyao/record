package com.yuanbao.record.mbp.mapper.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Cart implements Serializable {
    static final Long serialVersionUID = 1L;
    private Long id;
    private Long userId;
    private Long productSkusId;
    private Integer productSkusNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean deleted;
}
