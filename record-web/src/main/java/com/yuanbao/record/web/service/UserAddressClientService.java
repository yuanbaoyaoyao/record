package com.yuanbao.record.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.UserAddress;

import java.util.List;

public interface UserAddressClientService extends IService<UserAddress> {
    List<UserAddress> selectByUserId(Long userId);

    int insert(UserAddress userAddress);

    int updateByPrimaryKey(UserAddress userAddress);

    int deleteByPrimaryKey(long tempId);
}
