package com.yuanbao.record.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.admin.annotation.RequiresPermissionsDesc;
import com.yuanbao.record.admin.service.UserService;
import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.common.annotation.OperationLog;
import com.yuanbao.record.mbp.mapper.entity.User;
import com.yuanbao.record.mbp.vo.UserVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequiresPermissionsDesc(menu = {"用户管理", "用户列表"}, button = "查询")
    @OperationLog(menu = {"用户管理", "用户列表"}, action = "查询")
    @RequiresPermissions("user:list")
    @GetMapping(value = "/list")
    public CommonResult<IPage<UserVo>> getAllUser(
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "keyword", defaultValue = "null") String keyword) {
        IPage<User> page = new Page<>();
        IPage<UserVo> voPage = userService.selectListSearch(pageNum, pageSize, page, keyword);
        return CommonResult.success(voPage);
    }

    @RequiresPermissionsDesc(menu = {"用户管理", "用户列表"}, button = "创建")
    @OperationLog(menu = {"用户管理", "用户列表"}, action = "创建")
    @RequiresPermissions("user:create")
    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody User user) {
        int newId = userService.insert(user);
        if (newId > 0) {
            return CommonResult.success(newId);
        } else {
            return CommonResult.failed();
        }
    }

    @RequiresPermissionsDesc(menu = {"用户管理", "用户列表"}, button = "删除")
    @OperationLog(menu = {"用户管理", "用户列表"}, action = "删除")
    @RequiresPermissions("user:delete")
    @DeleteMapping(value = "/delete")
    public CommonResult delete(@RequestBody User user) {
        long tempId = user.getId();
        int count = userService.deleteByPrimaryKey(tempId);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @RequiresPermissionsDesc(menu = {"用户管理", "用户列表"}, button = "修改")
    @OperationLog(menu = {"用户管理", "用户列表"}, action = "修改")
    @RequiresPermissions("user:update")
    @PutMapping(value = "/update")
    public CommonResult update(@RequestBody User user) {
        int count = userService.updateByPrimaryKey(user);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

}
