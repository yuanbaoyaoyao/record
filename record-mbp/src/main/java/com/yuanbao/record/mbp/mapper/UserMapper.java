package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuanbao.record.mbp.mapper.entity.User;
import com.yuanbao.record.mbp.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    IPage<UserVo> selectListSearch(Integer pageNum, Integer pageSize, IPage<UserVo> page, String keyword);

    int updateByPrimaryKey(User user);
}
