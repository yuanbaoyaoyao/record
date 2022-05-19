package com.yuanbao.record.shiro.service.impl;

import com.yuanbao.record.admin.service.AdminTokenService;
import com.yuanbao.record.shiro.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShiroServiceImpl implements ShiroService {

    @Autowired
    private AdminTokenService adminTokenService;



//    @Override
//    public CommonResult createUserToken(Long userId) {
//        String token = TokenGenerator.generateValue();
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime expireTime = now.plusHours(EXPIRE);
//        AdminToken adminToken = adminTokenService.selectByUserId(userId);
//        if (adminToken == null) {
//            adminToken = new AdminToken();
//            adminToken.setAdminUserId(userId);
//            adminToken.setToken(token);
//            adminToken.setExpirationTime(expireTime);
//            adminTokenService.insert(adminToken);
//        } else {
//            adminToken.setToken(token);
//            adminToken.setExpirationTime(expireTime);
//            adminTokenService.updateByPrimaryKey(adminToken);
//        }
//        return CommonResult.success(adminToken);
//    }
//
//    @Override
//    public CommonResult createClientToken(Long userId) {
//        String token = TokenGenerator.generateValue();
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime expireTime = now.plusHours(EXPIRE);
//        UserToken userToken = userTokenService.selectByUserId(userId);
//        if (userToken == null) {
//            userToken = new UserToken();
//            userToken.setUserId(userId);
//            userToken.setToken(token);
//            userToken.setExpirationTime(expireTime);
//            userTokenService.insert(userToken);
//        } else {
//            userToken.setToken(token);
//            userToken.setExpirationTime(expireTime);
//            userTokenService.updateByPrimaryKey(userToken);
//        }
//        return CommonResult.success(userToken);
//    }
//
//    @Override
//    public void logout(String token) {
//        AdminToken adminToken = selectByAdminToken(token);
//        token = TokenGenerator.generateValue();
//        adminToken.setToken(token);
//        adminTokenService.updateByPrimaryKey(adminToken);
//    }
//
//    @Override
//    public void clientLogout(String token) {
//        UserToken userToken = selectByUserToken(token);
//        token = TokenGenerator.generateValue();
//        userToken.setToken(token);
//        userTokenService.updateByPrimaryKey(userToken);
//    }
//
//    @Override
//    public AdminToken selectByAdminToken(String accessToken) {
//        return adminTokenService.selectByToken(accessToken);
//    }
//
//    @Override
//    public UserToken selectByUserToken(String accessToken) {
//        return userTokenService.selectByToken(accessToken);
//    }



}
