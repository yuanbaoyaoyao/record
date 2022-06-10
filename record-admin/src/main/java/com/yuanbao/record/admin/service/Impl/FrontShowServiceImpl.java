package com.yuanbao.record.admin.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.admin.service.FrontShowService;
import com.yuanbao.record.mbp.mapper.FrontShowMapper;
import com.yuanbao.record.mbp.mapper.entity.FrontShow;
import com.yuanbao.record.mbp.vo.FrontShowVo;
import com.yuanbao.record.mbp.vomapper.FrontShowVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FrontShowServiceImpl extends ServiceImpl<FrontShowMapper, FrontShow> implements FrontShowService {

    @Autowired
    private FrontShowMapper frontShowMapper;

    @Override
    public List<FrontShowVo> selectByShowRotation() {
        List<FrontShowVo> frontShowVoList = new ArrayList<>();
        List<FrontShow> frontShowList = frontShowMapper.selectByShowRotation();
        System.out.println("-----------------------");
        System.out.println("selectByShowRotation:"+frontShowList);
        System.out.println("-----------------------");
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
        System.out.println("-----------------------");
        System.out.println("selectByShowOld:"+frontShowList);
        System.out.println("-----------------------");
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
        System.out.println("-----------------------");
        System.out.println("selectByShowNew:"+frontShowList);
        System.out.println("-----------------------");
        for (FrontShow frontShow : frontShowList) {
            FrontShowVo frontShowVo = FrontShowVoMapper.frontshowvomapper.Trans(frontShow);
            frontShowVoList.add(frontShowVo);
        }
        return frontShowVoList;
    }

    @Override
    public int insert(FrontShow frontShow) {
        return frontShowMapper.insert(frontShow);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return frontShowMapper.deleteById(id);
    }

    @Override
    public int updateByPrimaryKey(FrontShow frontShow) {
        return frontShowMapper.updateByPrimaryKey(frontShow);
    }
}
