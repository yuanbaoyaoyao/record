package com.yuanbao.record.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuanbao.record.mbp.mapper.entity.User;
import com.yuanbao.record.mbp.vo.UserVo;

public interface UserService {
    IPage<UserVo> selectListSearch(Integer pageNum, Integer pageSize, IPage<User> page, String keyword);

    int insert(User user);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKey(User user);
}
