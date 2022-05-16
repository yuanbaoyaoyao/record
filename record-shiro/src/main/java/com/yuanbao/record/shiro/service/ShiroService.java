package com.yuanbao.record.shiro.service;

import com.yuanbao.record.common.api.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.AdminToken;
import com.yuanbao.record.mbp.mapper.entity.UserToken;

public interface ShiroService {

    CommonResult createToken(Long userId);

    CommonResult createClientToken(Long userId);

    void logout(String token);

    void clientLogout(String token);

    AdminToken selectByAdminToken(String accessToken);

    UserToken selectByUserToken(String accessToken);

    void sendMailCode(String email);
}
