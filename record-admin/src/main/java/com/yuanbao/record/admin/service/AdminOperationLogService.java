package com.yuanbao.record.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.AdminOperationLog;
import com.yuanbao.record.mbp.vo.AdminOperationLogVo;

public interface AdminOperationLogService extends IService<AdminOperationLog> {
    IPage<AdminOperationLogVo> selectAdminOperationLogListSearch(Integer pageNum, Integer pageSize, IPage<AdminOperationLogVo> page, String keyword);

    int insert(AdminOperationLogVo adminOperationLogVo);
}
