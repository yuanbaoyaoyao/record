package com.yuanbao.record.admin.controller;

import com.yuanbao.record.admin.annotation.RequiresPermissionsDesc;
import com.yuanbao.record.admin.service.UserFeedbackDetailService;
import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.common.annotation.OperationLog;
import com.yuanbao.record.mbp.mapper.entity.UserFeedbackDetail;
import com.yuanbao.record.mbp.vo.UserFeedbackDetailVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/userFeedbackDetail")
public class UserFeedbackDetailController {
    @Autowired
    private UserFeedbackDetailService userFeedbackDetailService;

    @RequiresPermissionsDesc(menu = {"用户管理", "用户反馈细节"}, button = "查询")
    @OperationLog(menu = {"用户管理", "用户反馈细节"}, action = "查询")
    @RequiresPermissions("userFeedbackDetail:list")
    @GetMapping(value = "list")
    public CommonResult<List<UserFeedbackDetailVo>> getUserFeedbackDetail(
            @RequestParam(value = "userFeedbackId") Long userFeedbackId) {
        List<UserFeedbackDetailVo> userFeedbackDetailVoList = userFeedbackDetailService.selectUserFeedbackDetailByUserFeedbackId(userFeedbackId);
        return CommonResult.success(userFeedbackDetailVoList);
    }

    @RequiresPermissionsDesc(menu = {"用户管理", "用户反馈细节"}, button = "添加")
    @OperationLog(menu = {"用户管理", "用户反馈细节"}, action = "添加")
    @RequiresPermissions("userFeedbackDetail:create")
    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody UserFeedbackDetail userFeedbackDetail) {
        int newId = userFeedbackDetailService.insert(userFeedbackDetail);
        if (newId > 0) {
            return CommonResult.success(newId);
        } else {
            return CommonResult.failed();
        }
    }

}
