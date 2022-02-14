package com.yuanbao.record.mbp.mapper.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class User implements Serializable {
    static final Long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String email;
    private String emailVerifiedAt;
    private String password;
    private Boolean enable;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Boolean deleted;
}
