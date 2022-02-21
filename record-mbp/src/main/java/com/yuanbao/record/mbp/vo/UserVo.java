package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserVo {
//    private Integer pageSize;
//    private Integer pageNum;
//    private Long pageTotal;
//    private List<User> userList;
    private String name;
    private String avatar;
    private String email;
    private LocalDateTime emailVerifiedAt;
    private Boolean enable;
    private String password;
    private LocalDateTime createdAt;
}
