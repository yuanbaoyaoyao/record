package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuanbao.record.mbp.mapper.entity.UserToken;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserTokenMapper extends BaseMapper<UserToken> {
        UserToken selectByToken(String token);

        UserToken selectByUserId(Long userId);

        int insert(UserToken userToken);

        int updateByPrimaryKey(UserToken userToken);
}
