package com.yuanbao.record.mbp.mapper.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Product implements Serializable {
    static final Long serialVersionUID = 1L;
    private Long id;
    private String title;
    private String avatar;
    private String description;
    private Integer type;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean deleted;
}
