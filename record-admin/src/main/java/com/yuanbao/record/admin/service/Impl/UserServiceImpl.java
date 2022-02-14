package com.yuanbao.record.admin.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.admin.service.UserService;
import com.yuanbao.record.mbp.mapper.UserMapper;
import com.yuanbao.record.mbp.mapper.entity.User;
import com.yuanbao.record.mbp.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<UserVo> selectListSearch(Integer pageNum, Integer pageSize, IPage<UserVo> page, String keyword) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        return userMapper.selectListSearch(pageNum, pageSize, page, keyword);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int updateByPrimaryKey(User user) {
        return userMapper.updateByPrimaryKey(user);
    }
}
