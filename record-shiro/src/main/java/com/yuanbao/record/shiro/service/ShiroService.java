package com.yuanbao.record.shiro.service;

import com.yuanbao.record.common.api.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.AdminToken;

public interface ShiroService {

    CommonResult createToken(Long userId);

    void logout(String token);

    AdminToken selectByToken(String accessToken);
}
