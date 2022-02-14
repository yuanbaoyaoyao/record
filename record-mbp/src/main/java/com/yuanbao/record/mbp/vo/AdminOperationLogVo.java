package com.yuanbao.record.mbp.vo;

import com.yuanbao.record.mbp.mapper.entity.AdminOperationLog;
import lombok.Data;

import java.util.List;

@Data
public class AdminOperationLogVo {
    private Integer pageSize;
    private Integer pageNum;
    private Long pageTotal;
    private List<AdminOperationLog> adminOperationLogList;
}
