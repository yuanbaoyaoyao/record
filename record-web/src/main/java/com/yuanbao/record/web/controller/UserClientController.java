package com.yuanbao.record.web.controller;

import com.yuanbao.record.web.service.UserClientService;
import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.User;
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
        System.out.println("user:"+user);
        int newId = userClientService.register(user);
        if (newId > 0) {
            return CommonResult.success(newId);
        } else {
            return CommonResult.failed();
        }
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

    @PostMapping("/sendEmailCode")
    public CommonResult sendEmailCode(@RequestParam String email) {
        System.out.println("email:" + email);
        userClientService.sendMailCode(email);
        return CommonResult.success("已发送");
    }

}