package com.yuanbao.record.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.FrontShow;
import com.yuanbao.record.mbp.vo.FrontShowVo;

import java.util.List;

public interface FrontShowClientService extends IService<FrontShow> {
    List<FrontShowVo> selectByShowRotation();

    List<FrontShowVo> selectByShowOld();

    List<FrontShowVo> selectByShowNew();
}
