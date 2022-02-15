package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class AdminUserVo {
//    private Integer pageSize;
//    private Integer pageNum;
//    private Long pageTotal;
    private Long id;
    private String name;
    private String password;
    private String avatar;
    private String role;
    private Timestamp createdAt;
}
