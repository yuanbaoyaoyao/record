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
    public UserAddress selectById(Long id) {
        return userAddressMapper.selectById(id);
    }

    @Override
    public int insert(UserAddress userAddress) {
        return userAddressMapper.insert(userAddress);
    }

    @Override
    public int updateByPrimaryKey(UserAddress userAddress) {
        if (userAddress.getIsDefault()) {
            userAddressMapper.updateIsDefault(userAddress.getUserId());
        }
        return userAddressMapper.updateByPrimaryKey(userAddress);
    }

    @Override
    public int deleteByPrimaryKey(long tempId) {
        return userAddressMapper.deleteById(tempId);
    }
}
