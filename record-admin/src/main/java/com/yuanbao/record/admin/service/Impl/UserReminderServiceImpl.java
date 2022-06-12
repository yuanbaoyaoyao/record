package com.yuanbao.record.admin.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.admin.service.UserReminderService;
import com.yuanbao.record.mbp.mapper.UserReminderMapper;
import com.yuanbao.record.mbp.mapper.entity.UserReminder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserReminderServiceImpl extends ServiceImpl<UserReminderMapper, UserReminder> implements UserReminderService {

    @Autowired
    private UserReminderMapper userReminderMapper;

    @Override
    public int insert(UserReminder userReminder) {
        return userReminderMapper.insert(userReminder);
    }
}
