package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuanbao.record.mbp.mapper.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    IPage<User> selectListSearch(Integer pageNum, Integer pageSize, IPage<User> page, String keyword);

    User selectUserListByName(String userName);

    int insert(User user);

    int updateByPrimaryKey(User user);
}
