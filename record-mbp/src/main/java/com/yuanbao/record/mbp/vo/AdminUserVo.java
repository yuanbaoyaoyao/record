package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdminUserVo {
    private Long id;
    private String name;
    private String password;
    private String avatar;
    private String role;
    private String lastLoginIp;
    private LocalDateTime lastLoginTime;
    private String nowLoginIp;
    private LocalDateTime nowLoginTime;
    private LocalDateTime createdAt;
}
