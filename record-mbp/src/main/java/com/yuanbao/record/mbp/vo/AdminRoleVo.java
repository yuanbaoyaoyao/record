package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class AdminRoleVo {
    //    private Integer pageSize;
//    private Integer pageNum;
//    private Long pageTotal;
//    private List<AdminRole> adminRoleList;
    private String name;
    private String description;
    private Timestamp createdAt;
}
