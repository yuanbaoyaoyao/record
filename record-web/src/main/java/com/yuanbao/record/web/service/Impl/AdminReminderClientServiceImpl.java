package com.yuanbao.record.web.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.mbp.mapper.AdminReminderMapper;
import com.yuanbao.record.mbp.mapper.entity.AdminReminder;
import com.yuanbao.record.web.service.AdminReminderClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminReminderClientServiceImpl extends ServiceImpl<AdminReminderMapper, AdminReminder> implements AdminReminderClientService {

    @Autowired
    private AdminReminderMapper adminReminderMapper;

    @Override
    public int insert(AdminReminder adminReminder) {
        return adminReminderMapper.insert(adminReminder);
    }
}
