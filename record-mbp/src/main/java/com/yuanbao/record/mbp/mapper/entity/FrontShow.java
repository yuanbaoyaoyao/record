package com.yuanbao.record.mbp.mapper.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class FrontShow implements Serializable {
    static final Long serialVersionUID = 1L;
    private Long id;
    private Long productSkusId;
    private String productSkusName;
    private String productName;
    private String avatar;
    private Boolean showRotation;
    private Boolean showOld;
    private Boolean showNew;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean deleted;
}
