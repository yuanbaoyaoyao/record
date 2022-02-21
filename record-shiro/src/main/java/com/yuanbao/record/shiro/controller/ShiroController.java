package com.yuanbao.record.shiro.controller;

import com.yuanbao.record.admin.service.AdminUserService;
import com.yuanbao.record.common.api.CommonResult;
import com.yuanbao.record.mbp.dto.AdminLoginDto;
import com.yuanbao.record.mbp.mapper.entity.AdminUser;
import com.yuanbao.record.shiro.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("sys")
public class ShiroController {

    @Autowired
    private ShiroService shiroService;

    @Autowired
    private AdminUserService adminUserService;

    @PostMapping("/login")
    public CommonResult login(@RequestBody @Validated AdminLoginDto adminLoginDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return CommonResult.validateFailed(bindingResult.getFieldError().getDefaultMessage());
        }
        String username = adminLoginDto.getUsername();
        String password = adminLoginDto.getPassword();
        System.out.println("1");

        AdminUser adminUser = adminUserService.selectAdminListByName(username);
        System.out.println("2");

        if (adminUser == null || !adminUser.getPassword().equals(password)) {
            return CommonResult.validateFailed("账号或密码错误");
        } else {
            return shiroService.createToken(adminUser.getId());
        }
    }

    @PostMapping("/logout")
    public CommonResult logout(@RequestHeader("token")String token){
        shiroService.logout(token);
        return CommonResult.success(200,"您已安全退出系统");
    }
}
