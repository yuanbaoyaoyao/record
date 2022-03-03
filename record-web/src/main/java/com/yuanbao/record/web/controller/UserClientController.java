package com.yuanbao.record.web.controller;

import com.yuanbao.record.web.service.UserClientService;
import com.yuanbao.record.common.api.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/client/user")
public class UserClientController {

    @Autowired
    private UserClientService userClientService;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody User user) {
        int newId = userClientService.insert(user);
        if (newId > 0) {
            return CommonResult.success(newId);
        } else {
            return CommonResult.failed();
        }
    }

    @PutMapping(value = "/update")
    public CommonResult update(@RequestBody User user) {
        int count = userClientService.updateByPrimaryKey(user);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

}