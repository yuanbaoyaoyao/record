package com.yuanbao.record.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.admin.service.AdminUserService;
import com.yuanbao.record.common.api.CommonResult;
import com.yuanbao.record.mbp.entity.AdminUser;
import com.yuanbao.record.mbp.vo.AdminUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("adminUser")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    @GetMapping(value = "/list")
    public CommonResult<IPage<AdminUserVo>> getAllAdminUser(
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "keyword", defaultValue = "null") String keyword) {
        IPage<AdminUserVo> page = new Page<>();
        IPage<AdminUserVo> adminUserIPage = adminUserService.selectAdminListSearch(pageNum, pageSize, page, keyword);
        return CommonResult.success(adminUserIPage);
    }

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody AdminUser adminUser) {
        int newId = adminUserService.insert(adminUser);
        if (newId > 0) {
            return CommonResult.success(newId);
        } else {
            return CommonResult.failed();
        }
    }
}
