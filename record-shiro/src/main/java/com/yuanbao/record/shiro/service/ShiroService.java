package com.yuanbao.record.shiro.service;

public interface ShiroService {

//    CommonResult createUserToken(Long userId);
//
//    CommonResult createClientToken(Long userId);
//
//    void logout(String token);
//
//    void clientLogout(String token);

//    AdminToken selectByAdminToken(String accessToken);
//
//    UserToken selectByUserToken(String accessToken);

    void sendMailCode(String email);
}
