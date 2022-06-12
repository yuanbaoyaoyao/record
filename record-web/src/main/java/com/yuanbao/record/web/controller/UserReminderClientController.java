package com.yuanbao.record.web.controller;

import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.UserReminder;
import com.yuanbao.record.mbp.vo.UserReminderVo;
import com.yuanbao.record.web.service.UserReminderClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/userReminderClient")
public class UserReminderClientController {

    @Autowired
    private UserReminderClientService userReminderClientService;

    @GetMapping(value = "/list")
    public CommonResult<List<UserReminderVo>> getUserReminder(@RequestParam(value = "userId") Long userId) {
        List<UserReminderVo> userReminderVoList = userReminderClientService.selectListByUserId(userId);
        return CommonResult.success(userReminderVoList);
    }

    @PutMapping(value = "/update")
    public CommonResult update(@RequestBody UserReminder userReminder) {
        int count = userReminderClientService.updateByPrimaryKey(userReminder);
        return CommonResult.success(count);

    }
}
