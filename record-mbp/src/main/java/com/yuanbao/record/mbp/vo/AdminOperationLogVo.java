package com.yuanbao.record.mbp.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdminOperationLogVo {
    //    private Integer pageSize;
//    private Integer pageNum;
//    private Long pageTotal;
//    private List<AdminOperationLog> adminOperationLogList;
    private Long id;
    private String ip;
    private String adminUserName;
    private String action;
    private String menu;
    private String result;
    private LocalDateTime createdAt;
}
