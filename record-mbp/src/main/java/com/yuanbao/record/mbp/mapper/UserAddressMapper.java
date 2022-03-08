package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuanbao.record.mbp.mapper.entity.UserAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserAddressMapper extends BaseMapper<UserAddress> {
    List<UserAddress> selectByUserId(Long userId);

    int insert(UserAddress userAddress);

    int updateByPrimaryKey(UserAddress userAddress);
}
