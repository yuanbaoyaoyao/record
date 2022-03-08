package com.yuanbao.record.web.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.mbp.mapper.UserAddressMapper;
import com.yuanbao.record.mbp.mapper.entity.UserAddress;
import com.yuanbao.record.web.service.UserAddressClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddressClientServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements UserAddressClientService {

    @Autowired
    private UserAddressMapper userAddressMapper;

    @Override
    public List<UserAddress> selectByUserId(Long userId) {
        return userAddressMapper.selectByUserId(userId);
    }

    @Override
    public int insert(UserAddress userAddress) {
        int id = userAddressMapper.insert(userAddress);
        return id;
    }

    @Override
    public int updateByPrimaryKey(UserAddress userAddress) {
        return userAddressMapper.updateByPrimaryKey(userAddress);
    }

    @Override
    public int deleteByPrimaryKey(long tempId) {
        return userAddressMapper.deleteById(tempId);
    }
}
