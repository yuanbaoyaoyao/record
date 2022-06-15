package com.yuanbao.record.web.controller;

import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.mbp.mapper.UserReminderMapper;
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

    @Autowired
    private UserReminderMapper userReminderMapper;

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

    @PutMapping(value = "/updateByIds")
    public CommonResult updateByIds(@RequestBody List<UserReminder> userReminderList) {
        for (UserReminder userReminder : userReminderList) {
            userReminderClientService.updateByPrimaryKey(userReminder);
        }
        return CommonResult.success("全部修改成功");
    }

    @DeleteMapping(value = "/delete")
    public CommonResult delete(@RequestBody UserReminder userReminder) {
        long tempId = userReminder.getId();
        int count = userReminderClientService.deleteByPrimaryKey(tempId);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @DeleteMapping(value = "/deleteByIds")
    public CommonResult deleteByIds(@RequestBody List<UserReminder> userReminderList) {
        for (UserReminder userReminder : userReminderList) {
            userReminderClientService.deleteByPrimaryKey(userReminder.getId());
        }
        return CommonResult.success("全部删除成功");
    }

}
