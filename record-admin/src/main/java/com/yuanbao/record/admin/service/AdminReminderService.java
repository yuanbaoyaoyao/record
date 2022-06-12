package com.yuanbao.record.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.AdminReminder;
import com.yuanbao.record.mbp.vo.AdminReminderVo;

import java.util.List;

public interface AdminReminderService extends IService<AdminReminder> {
    List<AdminReminderVo> selectList();

    int updateByPrimaryKey(AdminReminder adminReminder);
}
