package com.yuanbao.record.admin.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.admin.service.AdminOperationLogService;
import com.yuanbao.record.mbp.mapper.AdminOperationLogMapper;
import com.yuanbao.record.mbp.mapper.entity.AdminOperationLog;
import com.yuanbao.record.mbp.vo.AdminOperationLogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminOperationLogServiceImpl extends ServiceImpl<AdminOperationLogMapper, AdminOperationLog> implements AdminOperationLogService {
    @Autowired
    private AdminOperationLogMapper adminOperationLogMapper;

    @Override
    public IPage<AdminOperationLogVo> selectAdminOperationLogListSearch(Integer pageNum, Integer pageSize, IPage<AdminOperationLogVo> page, String keyword) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        return adminOperationLogMapper.selectAdminOperationLogListSearch(pageNum, pageSize, page, keyword);
    }

    @Override
    public int insert(AdminOperationLogVo adminOperationLogVo) {
        int id = adminOperationLogMapper.insert(adminOperationLogVo);
        return id;
    }
}
