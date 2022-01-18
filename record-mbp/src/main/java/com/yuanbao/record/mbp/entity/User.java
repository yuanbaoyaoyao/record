package com.yuanbao.record.mbp.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class User {
    private Long id;
    private String name;
    private String email;
    private String emailVerifiedAt;
    private String password;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Boolean deleted;
}
