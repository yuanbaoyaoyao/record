package com.yuanbao.record.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.Announcement;
import com.yuanbao.record.mbp.vo.AnnouncementVo;

import java.util.List;

public interface AnnouncementClientService extends IService<Announcement> {
    List<AnnouncementVo> selectAll();
}
