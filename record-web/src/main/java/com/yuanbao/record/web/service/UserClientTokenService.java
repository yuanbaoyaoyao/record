package com.yuanbao.record.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.UserToken;

public interface UserClientTokenService extends IService<UserToken> {
    UserToken selectByToken(String token);

    UserToken selectByUserId(Long userId);

    int insert(UserToken userToken);

    int updateByPrimaryKey(UserToken userToken);
}
