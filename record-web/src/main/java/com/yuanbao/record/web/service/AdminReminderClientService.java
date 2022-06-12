package com.yuanbao.record.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.AdminReminder;

public interface AdminReminderClientService extends IService<AdminReminder> {

    int insert(AdminReminder adminReminder);

}
