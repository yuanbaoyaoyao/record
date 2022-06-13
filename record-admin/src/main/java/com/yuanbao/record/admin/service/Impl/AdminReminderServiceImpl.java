package com.yuanbao.record.admin.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.admin.service.AdminReminderService;
import com.yuanbao.record.mbp.mapper.AdminReminderMapper;
import com.yuanbao.record.mbp.mapper.entity.AdminReminder;
import com.yuanbao.record.mbp.vo.AdminReminderVo;
import com.yuanbao.record.mbp.vomapper.AdminReminderVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminReminderServiceImpl extends ServiceImpl<AdminReminderMapper, AdminReminder> implements AdminReminderService {

    @Autowired
    private AdminReminderMapper adminReminderMapper;

    @Override
    public List<AdminReminderVo> selectList() {
        List<AdminReminder> adminReminderList = adminReminderMapper.selectList();
        List<AdminReminderVo> adminReminderVoList = new ArrayList<>();
        for (AdminReminder adminReminder : adminReminderList) {
            AdminReminderVo adminReminderVo = AdminReminderVoMapper.adminremindervomapper.Trans(adminReminder);
            adminReminderVoList.add(adminReminderVo);
        }
        return adminReminderVoList;
    }

    @Override
    public int updateByPrimaryKey(AdminReminder adminReminder) {
        return adminReminderMapper.updateByPrimaryKey(adminReminder);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return adminReminderMapper.deleteById(id);
    }
}
