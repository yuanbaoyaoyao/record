package com.yuanbao.record.shiro.service.impl;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import com.yuanbao.record.admin.service.AdminTokenService;
import com.yuanbao.record.common.api.service.EmailService;
import com.yuanbao.record.common.api.util.RedisUtils;
import com.yuanbao.record.mbp.dto.EmailDto;
import com.yuanbao.record.shiro.service.ShiroService;
import com.yuanbao.record.web.service.UserClientService;
import com.yuanbao.record.web.service.UserClientTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ShiroServiceImpl implements ShiroService {

    @Autowired
    private AdminTokenService adminTokenService;

    @Autowired
    private UserClientService userClientService;

    @Autowired
    private UserClientTokenService userTokenService;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private EmailService emailService;

    private final static int EXPIRE = 12;

    @Value("${code.expiration}")
    private Long expiration;

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

    @Override
    public void sendMailCode(String email) {
        if (userClientService.isExistEmail(email)) {
            throw new RuntimeException("邮箱已存在");
        }

        TemplateEngine engine = TemplateUtil.createEngine(new TemplateConfig("template", TemplateConfig.ResourceMode.CLASSPATH));
        Template template = engine.getTemplate("email-code.ftl");

        Object code = redisUtils.get(email);
        if (code == null) {
            code = RandomUtil.randomNumbers(6);
            if (!redisUtils.set(email, code, expiration)) {
                throw new RuntimeException("后台服务器错误");
            }
        }
        emailService.send(new EmailDto(Collections.singletonList(email),
                "邮箱验证码", template.render(Dict.create().set("code", code))));
    }


}
