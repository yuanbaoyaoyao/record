package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class AdminOperationLogVo {
//    private Integer pageSize;
//    private Integer pageNum;
//    private Long pageTotal;
//    private List<AdminOperationLog> adminOperationLogList;
    private String ip;
    private Integer type;
    private String action;
    private Boolean status;
    private String result;
    private Timestamp createdAt;
}
