package com.yuanbao.record.web.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.mbp.mapper.AnnouncementMapper;
import com.yuanbao.record.mbp.mapper.entity.Announcement;
import com.yuanbao.record.mbp.vo.AnnouncementVo;
import com.yuanbao.record.mbp.vomapper.AnnouncementVoMapper;
import com.yuanbao.record.web.service.AnnouncementClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnnouncementClientServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement> implements AnnouncementClientService {

    @Autowired
    private AnnouncementMapper announcementMapper;

    @Override
    public List<AnnouncementVo> selectAll() {
        List<AnnouncementVo> announcementVoList = new ArrayList<>();
        List<Announcement> announcementList = announcementMapper.selectAll();
        for (Announcement announcement : announcementList) {
            AnnouncementVo announcementVo = AnnouncementVoMapper.announcementvomapper.Trans(announcement);
            announcementVoList.add(announcementVo);
        }
        return announcementVoList;
    }
}
