package com.yuanbao.record.admin.controller;

import com.yuanbao.record.admin.annotation.RequiresPermissionsDesc;
import com.yuanbao.record.admin.service.AdminReminderService;
import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.common.annotation.OperationLog;
import com.yuanbao.record.mbp.mapper.entity.AdminReminder;
import com.yuanbao.record.mbp.vo.AdminReminderVo;
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

    @RequiresPermissionsDesc(menu = {"消息提醒", "消息列表"}, button = "查询")
    @OperationLog(menu = {"消息提醒", "消息列表"}, action = "查询")
    @RequiresPermissions("adminReminder:list")
    @GetMapping(value = "/list")
    public CommonResult<List<AdminReminderVo>> getAdminReminder() {
        List<AdminReminderVo> adminReminderVoList = adminReminderService.selectList();
        return CommonResult.success(adminReminderVoList);
    }

    @RequiresPermissionsDesc(menu = {"消息提醒", "消息列表"}, button = "修改")
    @RequiresPermissions("adminReminder:update")
    @OperationLog(menu = {"消息提醒", "消息列表"}, action = "修改")
    @PutMapping(value = "/update")
    public CommonResult update(@RequestBody AdminReminder adminReminder) {
        int count = adminReminderService.updateByPrimaryKey(adminReminder);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
