package com.yuanbao.record.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.admin.service.UserService;
import com.yuanbao.record.common.api.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.User;
import com.yuanbao.record.mbp.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    public CommonResult<IPage<UserVo>> getAllUser(
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "keyword", defaultValue = "null") String keyword) {
        IPage<User> page = new Page<>();
        IPage<UserVo> voPage = userService.selectListSearch(pageNum, pageSize, page, keyword);
        return CommonResult.success(voPage);
    }

    @PostMapping(value = "/delete")
    public CommonResult delete(@RequestBody User user) {
        long tempId = user.getId();
        int count = userService.deleteByPrimaryKey(tempId);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @PostMapping(value = "/update")
    public CommonResult update(@RequestBody User user) {
        int count = userService.updateByPrimaryKey(user);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

}
