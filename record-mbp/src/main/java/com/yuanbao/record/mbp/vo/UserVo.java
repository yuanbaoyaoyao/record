package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserVo {
//    private Integer pageSize;
//    private Integer pageNum;
//    private Long pageTotal;
//    private List<User> userList;
    private String name;
    private String avatar;
    private String email;
    private Timestamp emailVerifiedAt;
    private Boolean enable;
    private String password;
    private Timestamp createdAt;
}
