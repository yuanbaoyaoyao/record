package com.yuanbao.record.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.admin.service.UserFeedbackService;
import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.common.annotation.OperationLog;
import com.yuanbao.record.mbp.mapper.entity.UserFeedback;
import com.yuanbao.record.mbp.vo.UserFeedbackVo;
import com.yuanbao.record.shiro.annotation.RequiresPermissionsDesc;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/userFeedback")
public class UserFeedbackController {
    @Autowired
    private UserFeedbackService userFeedbackService;

    @RequiresPermissionsDesc(menu = {"用户管理", "用户反馈"}, button = "查询")
    @OperationLog(menu = {"用户管理", "用户反馈"}, action = "查询")
    @RequiresPermissions("userFeedback:list")
    @GetMapping(value = "list")
    public CommonResult<IPage<UserFeedbackVo>> getUserFeedback(
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "keyword", defaultValue = "null") String keyword) {
        IPage<UserFeedback> page = new Page<>();
        IPage<UserFeedbackVo> voPage = userFeedbackService.selectListSearch(pageNum, pageSize, page, keyword);
        return CommonResult.success(voPage);
    }

    @RequiresPermissionsDesc(menu = {"用户管理", "用户反馈"}, button = "修改")
    @OperationLog(menu = {"用户管理", "用户反馈"}, action = "修改")
    @RequiresPermissions("userFeedback:update")
    @PutMapping(value = "/update")
    public CommonResult update(@RequestBody UserFeedback userFeedback) {
        int count = userFeedbackService.updateByPrimaryKey(userFeedback);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

}
