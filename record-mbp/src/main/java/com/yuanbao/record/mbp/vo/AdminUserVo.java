package com.yuanbao.record.mbp.vo;

import com.yuanbao.record.mbp.entity.AdminUser;
import lombok.Data;

import java.util.List;

@Data
public class AdminUserVo {
    private Integer pageSize;
    private Integer pageNum;
    private Long pageTotal;
    private List<AdminUser> adminUserList;
}
