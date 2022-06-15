package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuanbao.record.mbp.mapper.entity.UserReminder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserReminderMapper extends BaseMapper<UserReminder> {
    List<UserReminder> selectListByUserId(Long userId);

    int insert(UserReminder userReminder);

    int updateByPrimaryKey(UserReminder userReminder);

    int updateUserFeedback();

    int updateOrderProduct();
}
