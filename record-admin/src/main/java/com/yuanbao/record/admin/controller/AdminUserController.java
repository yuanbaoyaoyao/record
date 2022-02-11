package com.yuanbao.record.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.admin.service.AdminUserService;
import com.yuanbao.record.common.api.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.AdminUser;
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

    @PostMapping(value = "/delete")
//    public CommonResult delete(@RequestParam("id") Long id){
    public CommonResult delete(@RequestBody AdminUser adminUser){
        long tempId = adminUser.getId();
        int count = adminUserService.deleteByPrimaryKey(tempId);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @PostMapping(value = "/update")
    public CommonResult update(@RequestBody AdminUser adminUser){
        int count = adminUserService.updateByPrimaryKey(adminUser);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
