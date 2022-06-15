package com.yuanbao.record.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.UserReminder;
import com.yuanbao.record.mbp.vo.UserReminderVo;

import java.util.List;

public interface UserReminderClientService extends IService<UserReminder> {

    List<UserReminderVo> selectListByUserId(Long userId);

    int updateByPrimaryKey(UserReminder userReminder);

    int deleteByPrimaryKey(Long id);

}
