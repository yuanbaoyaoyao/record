package com.yuanbao.record.web.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.mbp.mapper.UserReminderMapper;
import com.yuanbao.record.mbp.mapper.entity.UserReminder;
import com.yuanbao.record.mbp.vo.UserReminderVo;
import com.yuanbao.record.mbp.vomapper.UserReminderVoMapper;
import com.yuanbao.record.web.service.UserReminderClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserReminderClientServiceImpl extends ServiceImpl<UserReminderMapper, UserReminder> implements UserReminderClientService {

    @Autowired
    private UserReminderMapper userReminderMapper;

    @Override
    public List<UserReminderVo> selectListByUserId(Long userId) {
        List<UserReminder> userReminderList = userReminderMapper.selectListByUserId(userId);
        List<UserReminderVo> userReminderVoList = new ArrayList<>();
        for (UserReminder userReminder : userReminderList) {
            UserReminderVo userReminderVo = UserReminderVoMapper.userremindervomapper.Trans(userReminder);
            userReminderVoList.add(userReminderVo);
        }
        return userReminderVoList;
    }

    @Override
    public int updateByPrimaryKey(UserReminder userReminder) {
        return userReminderMapper.updateByPrimaryKey(userReminder);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userReminderMapper.deleteById(id);
    }
}
