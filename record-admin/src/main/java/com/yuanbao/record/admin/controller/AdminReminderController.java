package com.yuanbao.record.admin.controller;

import com.yuanbao.record.admin.service.AdminReminderService;
import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.common.annotation.OperationLog;
import com.yuanbao.record.mbp.mapper.AdminReminderMapper;
import com.yuanbao.record.mbp.mapper.entity.AdminReminder;
import com.yuanbao.record.mbp.vo.AdminReminderVo;
import com.yuanbao.record.shiro.annotation.RequiresPermissionsDesc;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/adminReminder")
public class AdminReminderController {
    @Autowired
    private AdminReminderService adminReminderService;
    @Autowired
    private AdminReminderMapper adminReminderMapper;

    @RequiresPermissionsDesc(menu = {"消息提醒", "消息列表"}, button = "查询")
    @OperationLog(menu = {"消息提醒", "消息列表"}, action = "查询")
    @RequiresPermissions("adminReminder:list")
    @GetMapping(value = "/list")
    public CommonResult<List<AdminReminderVo>> getAdminReminder() {
        List<AdminReminderVo> adminReminderVoList = adminReminderService.selectList();
        return CommonResult.success(adminReminderVoList);
    }

    @RequiresPermissionsDesc(menu = {"消息提醒", "消息列表"}, button = "单个修改")
    @RequiresPermissions("adminReminder:update")
    @OperationLog(menu = {"消息提醒", "消息列表"}, action = "单个修改")
    @PutMapping(value = "/update")
    public CommonResult update(@RequestBody AdminReminder adminReminder) {
        int count = adminReminderService.updateByPrimaryKey(adminReminder);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @RequiresPermissionsDesc(menu = {"消息提醒", "消息列表"}, button = "全部修改")
    @RequiresPermissions("adminReminder:update")
    @OperationLog(menu = {"消息提醒", "消息列表"}, action = "全部修改")
    @PutMapping(value = "/updateByIds")
    public CommonResult updateByIds() {
        List<AdminReminder> adminReminderList = adminReminderMapper.selectList();
        for (AdminReminder adminReminder : adminReminderList) {
            System.out.println("adminReminder:"+adminReminder);
            adminReminderService.updateByPrimaryKey(adminReminder);
        }
        return CommonResult.success("全部修改成功");
    }

    @RequiresPermissionsDesc(menu = {"消息提醒", "消息列表"}, button = "单个删除")
    @RequiresPermissions("adminReminder:delete")
    @OperationLog(menu = {"消息提醒", "消息列表"}, action = "单个删除")
    @DeleteMapping(value = "/delete")
    public CommonResult delete(@RequestBody AdminReminder adminReminder) {
        long tempId = adminReminder.getId();
        int count = adminReminderService.deleteByPrimaryKey(tempId);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @RequiresPermissionsDesc(menu = {"消息提醒", "消息列表"}, button = "全部删除")
    @RequiresPermissions("adminReminder:delete")
    @OperationLog(menu = {"消息提醒", "消息列表"}, action = "全部删除")
    @DeleteMapping(value = "/deleteByIds")
    public CommonResult deleteByIds() {
        List<AdminReminder> adminReminderList = adminReminderMapper.selectList();
        for (AdminReminder adminReminder : adminReminderList) {
            adminReminderService.deleteByPrimaryKey(adminReminder.getId());
        }
        return CommonResult.success("全部删除成功");
    }
}
