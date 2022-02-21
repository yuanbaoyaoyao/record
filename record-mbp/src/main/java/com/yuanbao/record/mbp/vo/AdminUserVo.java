package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.time.LocalDateTime;

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
    private LocalDateTime createdAt;
}
