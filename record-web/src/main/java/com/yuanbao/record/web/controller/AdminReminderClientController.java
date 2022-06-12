package com.yuanbao.record.web.controller;


import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.AdminReminder;
import com.yuanbao.record.web.service.AdminReminderClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/adminReminderClient")
public class AdminReminderClientController {

    @Autowired
    private AdminReminderClientService adminReminderClientService;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody AdminReminder adminReminder) {
        int newId = adminReminderClientService.insert(adminReminder);
        if (newId > 0) {
            return CommonResult.success(newId);
        } else {
            return CommonResult.failed();
        }
    }
}
