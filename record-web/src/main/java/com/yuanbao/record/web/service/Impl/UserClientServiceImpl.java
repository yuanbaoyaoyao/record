package com.yuanbao.record.web.service.Impl;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.common.service.EmailService;
import com.yuanbao.record.common.util.RedisUtils;
import com.yuanbao.record.common.util.SaltUtil;
import com.yuanbao.record.mbp.dto.EmailDto;
import com.yuanbao.record.mbp.mapper.UserMapper;
import com.yuanbao.record.mbp.mapper.entity.User;
import com.yuanbao.record.web.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserClientServiceImpl extends ServiceImpl<UserMapper, User> implements UserClientService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private EmailService emailService;

    @Value("${code.expiration}")
    private Long expiration;

    @Override
    public User selectUserListByName(String userName) {
        return userMapper.selectUserListByName(userName);
    }

    @Override
    public User selectUserByEmail(String email) {
        return userMapper.selectUserByEmail(email);
    }

    @Override
    public int register(User user) {
        Object value = redisUtils.get(user.getEmail());
        System.out.println("输入的邮箱地址为:" + user.getEmail());
        System.out.println("redis中的value为：" + value);
        if (value == null || !value.toString().equals(user.getEmailCode())) {
            throw new RuntimeException("无效验证码");
        }
        System.out.println("userrrrrrrrrrrr:" + user);
        String username = user.getName();
        String email = user.getEmail();
        String password = user.getPassword();
        if (userMapper.selectUserListByName(username) != null) {
            throw new RuntimeException("用户名已存在");
        }
        if (userMapper.selectUserByEmail(email) != null) {
            throw new RuntimeException("邮箱已存在");
        }
        String salt = SaltUtil.generateSalt(30);
        user.setSalt(salt);
        System.out.println("password:" + password);
        System.out.println("salt:" + salt);
        System.out.println("DigestUtil.md5Hex(password, salt):" + SecureUtil.md5(password + salt));
        user.setPassword(SecureUtil.md5(password + salt));
        return userMapper.insert(user);
    }

    @Override
    public int forget(User user) {
        Object value = redisUtils.get(user.getEmail());
        if (value == null || !value.toString().equals(user.getEmailCode())) {
            throw new RuntimeException("无效验证码");
        }
        User user1 = userMapper.selectUserByEmail(user.getEmail());
        user1.setPassword(SecureUtil.md5(user.getPassword() + user1.getSalt()));
        return userMapper.updateByPrimaryKey(user1);
    }

    @Override
    public int updateByPrimaryKey(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public int updateAvatarByPrimaryKey(User user) {
        return userMapper.updateAvatarByPrimaryKey(user);
    }

    @Override
    public Boolean isExistEmail(String email) {
        User user = userMapper.selectUserByEmail(email);
        return user != null;
    }

    @Override
    public void sendMailCode(String email) {

        TemplateEngine engine = TemplateUtil.createEngine(new TemplateConfig("template", TemplateConfig.ResourceMode.CLASSPATH));
        Template template = engine.getTemplate("email-code.ftl");

        Object code = RandomUtil.randomNumbers(6);
        if (redisUtils.get(email) != null) {
            redisUtils.del(email);
        }
        if (!redisUtils.set(email, code, expiration)) {
            throw new RuntimeException("后台服务器错误");
        }
        emailService.send(new EmailDto(Collections.singletonList(email),
                "邮箱验证码", template.render(Dict.create().set("code", code))));
        System.out.println("codeeeeeeeeeee:" + code);
    }
}
