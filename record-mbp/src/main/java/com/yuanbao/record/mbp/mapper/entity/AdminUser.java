package com.yuanbao.record.mbp.mapper.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Setter
@Getter
@TableName("admin_user")
public class AdminUser implements Serializable {
    static final Long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String password;
    private String avatar;
    private Integer roleId;
    private String role;
//    List<AdminRole> adminRoleList;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Boolean deleted;
}
