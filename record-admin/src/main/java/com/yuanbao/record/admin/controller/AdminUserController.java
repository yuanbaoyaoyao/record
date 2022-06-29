package com.yuanbao.record.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.admin.service.AdminUserService;
import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.common.annotation.OperationLog;
import com.yuanbao.record.mbp.mapper.entity.AdminUser;
import com.yuanbao.record.mbp.vo.AdminUserVo;
import com.yuanbao.record.shiro.annotation.RequiresPermissionsDesc;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/adminUser")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    @RequiresPermissionsDesc(menu = {"权限管理", "管理员"}, button = "查询")
    @OperationLog(menu = {"权限管理", "管理员"}, action = "查询")
    @RequiresPermissions("adminUser:list")
    @GetMapping(value = "/list")
    public CommonResult<IPage<AdminUserVo>> getAllAdminUser(
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "keyword", defaultValue = "null") String keyword) {
        IPage<AdminUser> page = new Page<>();
        IPage<AdminUserVo> voPage = adminUserService.selectAdminListSearch(pageNum, pageSize, page, keyword);
        return CommonResult.success(voPage);
    }

    @RequiresPermissionsDesc(menu = {"权限管理", "管理员"}, button = "添加")
    @OperationLog(menu = {"权限管理", "管理员"}, action = "添加")
    @RequiresPermissions("adminUser:create")
    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody AdminUser adminUser) {
        int newId = adminUserService.insert(adminUser);
        if (newId > 0) {
            return CommonResult.success(newId);
        } else {
            return CommonResult.failed();
        }
    }

    @RequiresPermissionsDesc(menu = {"权限管理", "管理员"}, button = "删除")
    @OperationLog(menu = {"权限管理", "管理员"}, action = "删除")
    @RequiresPermissions("adminUser:delete")
    @DeleteMapping(value = "/delete")
//    public CommonResult delete(@RequestParam("id") Long id){
    public CommonResult delete(@RequestBody AdminUser adminUser) {
        long tempId = adminUser.getId();
        int count = adminUserService.deleteByPrimaryKey(tempId);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @RequiresPermissionsDesc(menu = {"权限管理", "管理员"}, button = "修改")
    @OperationLog(menu = {"权限管理", "管理员"}, action = "修改")
    @RequiresPermissions("adminUser:update")
    @PutMapping(value = "/update")
    public CommonResult update(@RequestBody AdminUser adminUser) {
        int count = adminUserService.updateByPrimaryKey(adminUser);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
