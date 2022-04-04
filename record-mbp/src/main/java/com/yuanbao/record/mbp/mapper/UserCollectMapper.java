package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuanbao.record.mbp.mapper.entity.UserCollect;
import com.yuanbao.record.mbp.vo.UserCollectVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserCollectMapper extends BaseMapper<UserCollect> {
    IPage<UserCollect> selectProductSkusByUserId(Integer pageNum, Integer pageSize, IPage<UserCollect> page, Long userId);

    List<UserCollectVo> selectIDByUserIdAndProuductSkusId(Long userId, Long productSkusId);

    int insert(UserCollect userCollect);
}
