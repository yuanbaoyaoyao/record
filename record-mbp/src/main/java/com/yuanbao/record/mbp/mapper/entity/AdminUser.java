package com.yuanbao.record.mbp.mapper.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("admin_user")
@AllArgsConstructor
@NoArgsConstructor
public class AdminUser implements Serializable {
    static final Long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String password;
    private String avatar;
    private Long roleId;
    private String role;
    private String lastLoginIp;
    private LocalDateTime lastLoginTime;
    private String nowLoginIp;
    private LocalDateTime nowLoginTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean deleted;
}
