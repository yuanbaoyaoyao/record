package com.yuanbao.record.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.admin.annotation.RequiresPermissionsDesc;
import com.yuanbao.record.admin.service.AdminRoleService;
import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.common.annotation.OperationLog;
import com.yuanbao.record.mbp.mapper.entity.AdminRole;
import com.yuanbao.record.mbp.vo.AdminRoleVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/adminRole")

public class AdminRoleController {

    @Autowired
    private AdminRoleService adminRoleService;

    @RequiresPermissionsDesc(menu = {"耗材管理", "角色管理"}, button = "查询")
    @OperationLog(menu = {"耗材管理", "角色管理"}, action = "查询")
    @RequiresPermissions("adminRole:list")
    @GetMapping(value = "list")
    public CommonResult<IPage<AdminRoleVo>> getAllAdminRole(
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "id", defaultValue = "") Long id,
            @RequestParam(value = "name", defaultValue = "null") String name) {
        IPage<AdminRole> page = new Page<>();
        IPage<AdminRoleVo> voPage = adminRoleService.selectRoleList(pageNum, pageSize, page, name, id);
        return CommonResult.success(voPage);
    }

    @RequiresPermissionsDesc(menu = {"权限管理", "角色管理"}, button = "添加")
    @OperationLog(menu = {"权限管理", "角色管理"}, action = "添加")
    @RequiresPermissions("adminRole:create")
    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody AdminRole adminRole) {
        int newId = adminRoleService.insert(adminRole);
        if (newId > 0) {
            return CommonResult.success(newId);
        } else {
            return CommonResult.failed();
        }
    }

    @RequiresPermissionsDesc(menu = {"权限管理", "角色管理"}, button = "删除")
    @OperationLog(menu = {"权限管理", "角色管理"}, action = "删除")
    @RequiresPermissions("adminRole:delete")
    @DeleteMapping(value = "/delete")
    public CommonResult delete(@RequestBody AdminRole adminRole) {
        long tempId = adminRole.getId();
        System.out.println("tempId:" + tempId);
        int count = adminRoleService.deleteByPrimaryKey(tempId);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @RequiresPermissionsDesc(menu = {"权限管理", "角色管理"}, button = "修改")
    @OperationLog(menu = {"权限管理", "角色管理"}, action = "修改")
    @RequiresPermissions("adminRole:update")
    @PutMapping(value = "/update")
    public CommonResult update(@RequestBody AdminRole adminRole) {
        int count = adminRoleService.updateByPrimaryKey(adminRole);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
