package com.yuanbao.record.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.FrontShow;
import com.yuanbao.record.mbp.vo.FrontShowVo;

import java.util.List;

public interface FrontShowService extends IService<FrontShow> {

    List<FrontShowVo> selectByShowRotation();

    List<FrontShowVo> selectByShowOld();

    List<FrontShowVo> selectByShowNew();

    int insert(FrontShow frontShow);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKey(FrontShow frontShow);

}
