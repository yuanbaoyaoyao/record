package com.yuanbao.record.admin.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.admin.service.UserService;
import com.yuanbao.record.mbp.mapper.UserMapper;
import com.yuanbao.record.mbp.mapper.entity.User;
import com.yuanbao.record.mbp.vo.UserVo;
import com.yuanbao.record.mbp.vomapper.UserVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<UserVo> selectListSearch(Integer pageNum, Integer pageSize, IPage<User> page, String keyword) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        IPage<UserVo> voPage = new Page<>();
        List<UserVo> userVoList = new ArrayList<>();
        IPage<User> userIPage = userMapper.selectListSearch(pageNum, pageSize, page, keyword);
        List<User> userList = userIPage.getRecords();
        for (User user : userList) {
            UserVo userVo = UserVoMapper.uservomapper.Trans(user);
            userVoList.add(userVo);
        }
        voPage.setRecords(userVoList);
        voPage.setCurrent(pageNum);
        voPage.setSize(pageSize);
        voPage.setTotal(userIPage.getTotal());
        return voPage;
    }

    @Override
    public int insert(User user) {
        int id = userMapper.insert(user);
        return id;
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
