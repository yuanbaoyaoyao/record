package com.yuanbao.record.admin.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.admin.service.AnnouncementService;
import com.yuanbao.record.mbp.mapper.AnnouncementMapper;
import com.yuanbao.record.mbp.mapper.entity.Announcement;
import com.yuanbao.record.mbp.vo.AnnouncementVo;
import com.yuanbao.record.mbp.vomapper.AnnouncementVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement> implements AnnouncementService {

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

    @Override
    public int insert(Announcement announcement) {
        return announcementMapper.insert(announcement);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return announcementMapper.deleteById(id);
    }

    @Override
    public int updateByPrimaryKey(Announcement announcement) {
        return announcementMapper.updateByPrimaryKey(announcement);
    }
}
