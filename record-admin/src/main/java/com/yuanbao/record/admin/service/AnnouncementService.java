package com.yuanbao.record.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.Announcement;
import com.yuanbao.record.mbp.vo.AnnouncementVo;

import java.util.List;

public interface AnnouncementService extends IService<Announcement> {
    List<AnnouncementVo> selectAll();

    int insert(Announcement announcement);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKey(Announcement announcement);
}
