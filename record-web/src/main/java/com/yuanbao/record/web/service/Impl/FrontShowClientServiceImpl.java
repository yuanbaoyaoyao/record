package com.yuanbao.record.web.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.mbp.mapper.FrontShowMapper;
import com.yuanbao.record.mbp.mapper.entity.FrontShow;
import com.yuanbao.record.mbp.vo.FrontShowVo;
import com.yuanbao.record.mbp.vomapper.FrontShowVoMapper;
import com.yuanbao.record.web.service.FrontShowClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FrontShowClientServiceImpl extends ServiceImpl<FrontShowMapper, FrontShow> implements FrontShowClientService {
    @Autowired
    private FrontShowMapper frontShowMapper;

    @Override
    public List<FrontShowVo> selectByShowRotation() {
        List<FrontShowVo> frontShowVoList = new ArrayList<>();
        List<FrontShow> frontShowList = frontShowMapper.selectByShowRotation();
        for (FrontShow frontShow : frontShowList) {
            FrontShowVo frontShowVo = FrontShowVoMapper.frontshowvomapper.Trans(frontShow);
            frontShowVoList.add(frontShowVo);
        }
        return frontShowVoList;
    }

    @Override
    public List<FrontShowVo> selectByShowOld() {
        List<FrontShowVo> frontShowVoList = new ArrayList<>();
        List<FrontShow> frontShowList = frontShowMapper.selectByShowOld();
        for (FrontShow frontShow : frontShowList) {
            FrontShowVo frontShowVo = FrontShowVoMapper.frontshowvomapper.Trans(frontShow);
            frontShowVoList.add(frontShowVo);
        }
        return frontShowVoList;
    }

    @Override
    public List<FrontShowVo> selectByShowNew() {
        List<FrontShowVo> frontShowVoList = new ArrayList<>();
        List<FrontShow> frontShowList = frontShowMapper.selectByShowNew();
        for (FrontShow frontShow : frontShowList) {
            FrontShowVo frontShowVo = FrontShowVoMapper.frontshowvomapper.Trans(frontShow);
            frontShowVoList.add(frontShowVo);
        }
        return frontShowVoList;
    }

}
