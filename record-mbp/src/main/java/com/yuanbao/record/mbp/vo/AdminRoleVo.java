package com.yuanbao.record.mbp.vo;

import com.yuanbao.record.mbp.mapper.entity.AdminRole;
import lombok.Data;

import java.util.List;

@Data
public class AdminRoleVo {
    private Integer pageSize;
    private Integer pageNum;
    private Long pageTotal;
    private List<AdminRole> adminRoleList;
}
