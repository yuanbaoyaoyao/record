package com.yuanbao.record.web.controller;

import com.yuanbao.record.mbp.mapper.entity.JwtUser;
import com.yuanbao.record.web.service.UserClientService;
import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/client/user")
public class UserClientController {

    @Autowired
    private UserClientService userClientService;

    @PostMapping(value = "/register")
    public CommonResult register(@RequestBody User user) {
        System.out.println("user:" + user);
        int newId = userClientService.register(user);
        if (newId > 0) {
            return CommonResult.success(newId);
        } else {
            return CommonResult.failed();
        }
    }

    @PostMapping(value = "/forget")
    public CommonResult forget(@RequestBody User user) {
        System.out.println("user:" + user);
        userClientService.forget(user);
        return CommonResult.success("修改密码成功");
    }

    @PutMapping(value = "/update")
    public CommonResult update(@RequestBody User user) {
        int count = userClientService.updateByPrimaryKey(user);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @PutMapping(value = "/updateAvatar")
    public CommonResult updateAvatar(@RequestBody User user) {
        int count = userClientService.updateAvatarByPrimaryKey(user);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @PostMapping("/sendEmailCode")
    public CommonResult sendEmailCode(@RequestParam String email) {
        JwtUser jwtUser = (JwtUser) SecurityUtils.getSubject().getPrincipal();
        User user = userClientService.selectUserByEmail(email);
        User user1 = userClientService.selectUserListByName(jwtUser.getUsername());
        System.out.println("email:" + email);
        if (user == null || user.getId() != user1.getId().longValue()) {
            return CommonResult.failed("邮件不存在");
        } else {
            userClientService.sendMailCode(email);
            return CommonResult.success("已发送");
        }
    }

}