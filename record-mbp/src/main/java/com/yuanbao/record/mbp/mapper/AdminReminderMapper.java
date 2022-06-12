package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuanbao.record.mbp.mapper.entity.AdminReminder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminReminderMapper extends BaseMapper<AdminReminder> {
    List<AdminReminder> selectList();

    int insert(AdminReminder adminReminder);

    int updateByPrimaryKey(AdminReminder adminReminder);
}
