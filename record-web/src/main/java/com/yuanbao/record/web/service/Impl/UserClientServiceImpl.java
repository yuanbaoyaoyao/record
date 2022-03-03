package com.yuanbao.record.web.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.web.service.UserClientService;
import com.yuanbao.record.mbp.mapper.UserMapper;
import com.yuanbao.record.mbp.mapper.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserClientServiceImpl extends ServiceImpl<UserMapper, User> implements UserClientService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserListByName(String userName) {
        return userMapper.selectUserListByName(userName);
    }

    @Override
    public int insert(User user) {
        int id = userMapper.insert(user);
        return id;
    }

    @Override
    public int updateByPrimaryKey(User user) {
        return userMapper.updateByPrimaryKey(user);
    }
}
