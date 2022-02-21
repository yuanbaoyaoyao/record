package com.yuanbao.record.shiro.service.impl;

import com.yuanbao.record.admin.service.AdminTokenService;
import com.yuanbao.record.common.api.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.AdminToken;
import com.yuanbao.record.shiro.auth.TokenGenerator;
import com.yuanbao.record.shiro.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ShiroServiceImpl implements ShiroService {

    @Autowired
    private AdminTokenService adminTokenService;

    private final static int EXPIRE = 12;

    @Override
    public CommonResult createToken(Long userId) {
        String token = TokenGenerator.generateValue();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expireTime = now.plusHours(EXPIRE);
        AdminToken adminToken = adminTokenService.selectByUserId(userId);
        if(adminToken==null){
            adminToken = new AdminToken();
            adminToken.setAdminUserId(userId);
            adminToken.setToken(token);
            adminToken.setExpirationTime(expireTime);
            adminTokenService.insert(adminToken);
        }else {
            adminToken.setToken(token);
            adminToken.setExpirationTime(expireTime);
            adminTokenService.updateByPrimaryKey(adminToken);
        }
        return CommonResult.success(adminToken);
    }

    @Override
    public void logout(String token) {
        AdminToken adminToken = selectByToken(token);
        token = TokenGenerator.generateValue();
        adminToken.setToken(token);
        adminTokenService.updateByPrimaryKey(adminToken);
    }

    @Override
    public AdminToken selectByToken(String accessToken) {
        return adminTokenService.selectByToken(accessToken);
    }
}
