package com.yuanbao.record.web.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.mbp.mapper.UserTokenMapper;
import com.yuanbao.record.mbp.mapper.entity.UserToken;
import com.yuanbao.record.web.service.UserClientTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserClientTokenServiceImpl extends ServiceImpl<UserTokenMapper, UserToken> implements UserClientTokenService {

    @Autowired
    private UserTokenMapper userTokenMapper;

    @Override
    public UserToken selectByToken(String token) {
        return userTokenMapper.selectByToken(token);
    }

    @Override
    public UserToken selectByUserId(Long userId) {
        return userTokenMapper.selectByUserId(userId);    }

    @Override
    public int insert(UserToken userToken) {
        return userTokenMapper.insert(userToken);
    }

    @Override
    public int updateByPrimaryKey(UserToken userToken) {
        return userTokenMapper.updateByPrimaryKey(userToken);
    }
}
