package com.yuanbao.record.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.admin.service.AdminUserService;
import com.yuanbao.record.mbp.entity.AdminUser;
import com.yuanbao.recordcommon.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("adminUser")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    @GetMapping(value = "/list")
    @ResponseBody
    public CommonResult<List<AdminUser>> getAllAdminUser(){
        IPage<AdminUser> page = new Page<AdminUser>(1,5);
        List<AdminUser> adminUserIPage = adminUserService.selectAdminList(page);
        return CommonResult.success(adminUserIPage);
    }
}
