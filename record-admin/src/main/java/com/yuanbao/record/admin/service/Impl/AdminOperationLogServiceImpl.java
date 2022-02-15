package com.yuanbao.record.admin.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.admin.service.AdminOperationLogService;
import com.yuanbao.record.mbp.mapper.AdminOperationLogMapper;
import com.yuanbao.record.mbp.mapper.entity.AdminOperationLog;
import com.yuanbao.record.mbp.vo.AdminOperationLogVo;
import com.yuanbao.record.mbp.vomapper.AdminOperationLogVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminOperationLogServiceImpl extends ServiceImpl<AdminOperationLogMapper, AdminOperationLog> implements AdminOperationLogService {
    @Autowired
    private AdminOperationLogMapper adminOperationLogMapper;

    @Override
    public IPage<AdminOperationLogVo> selectAdminOperationLogListSearch(Integer pageNum, Integer pageSize, IPage<AdminOperationLog> page, String keyword) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        IPage<AdminOperationLogVo> voPage = new Page<>();
        List<AdminOperationLogVo> AdminOperationLogVoList = new ArrayList<>();
        IPage<AdminOperationLog> AdminOperationLogIPage = adminOperationLogMapper.selectAdminOperationLogListSearch(pageNum, pageSize, page, keyword);
        List<AdminOperationLog> adminOperationLogList = AdminOperationLogIPage.getRecords();
        for (AdminOperationLog adminOperationLog : adminOperationLogList) {
            AdminOperationLogVo adminOperationLogVo = AdminOperationLogVoMapper.adminoperationlogvomapper.Trans(adminOperationLog);
            AdminOperationLogVoList.add(adminOperationLogVo);
        }
        voPage.setRecords(AdminOperationLogVoList);
        voPage.setCurrent(pageNum);
        voPage.setSize(pageSize);
        voPage.setTotal(AdminOperationLogIPage.getTotal());
        return voPage;
    }

    @Override
    public int insert(AdminOperationLogVo adminOperationLogVo) {
        int id = adminOperationLogMapper.insert(adminOperationLogVo);
        return id;
    }
}
