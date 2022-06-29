package com.yuanbao.record.admin.controller;

import com.yuanbao.record.admin.service.UserReminderService;
import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.common.annotation.OperationLog;
import com.yuanbao.record.mbp.mapper.entity.UserReminder;
import com.yuanbao.record.shiro.annotation.RequiresPermissionsDesc;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/userReminder")
public class UserReminderController {

    @Autowired
    private UserReminderService userReminderService;

    @RequiresPermissionsDesc(menu = {"消息提醒", "消息列表"}, button = "创建")
    @OperationLog(menu = {"消息提醒", "消息列表"}, action = "创建")
    @RequiresPermissions("userReminder:create")
    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody UserReminder userReminder) {
        int newId = userReminderService.insert(userReminder);
        if (newId > 0) {
            return CommonResult.success(newId);
        } else {
            return CommonResult.failed();
        }
    }
}
