package com.yuanbao.record.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.UserCollect;
import com.yuanbao.record.mbp.vo.UserCollectVo;

import java.util.List;

public interface UserCollectClientService extends IService<UserCollect> {
    IPage<UserCollectVo> selectProductSkusByUserId(Integer pageNum, Integer pageSize, IPage<UserCollect> page, Long userId);

    List<UserCollectVo> selectIDByUserIdAndProuductSkusId(Long userId, Long productSkusId);

    int insert(UserCollect userCollect);

    int deleteByPrimaryKey(Long id);
}
