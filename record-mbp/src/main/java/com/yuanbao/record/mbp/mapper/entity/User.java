package com.yuanbao.record.mbp.mapper.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class User implements Serializable {
    static final Long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String password;
    private String salt;
    private String avatar;
    private String email;
    private LocalDateTime emailVerifiedAt;
    private Boolean enable;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean deleted;
}
