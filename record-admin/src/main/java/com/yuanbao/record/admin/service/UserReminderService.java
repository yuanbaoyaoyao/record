package com.yuanbao.record.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.UserReminder;

public interface UserReminderService extends IService<UserReminder> {

    int insert(UserReminder userReminder);

}
