package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuanbao.record.mbp.mapper.entity.Announcement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnnouncementMapper extends BaseMapper<Announcement> {

    List<Announcement> selectAll();

    int insert(Announcement announcement);

    int updateByPrimaryKey(Announcement announcement);
}
