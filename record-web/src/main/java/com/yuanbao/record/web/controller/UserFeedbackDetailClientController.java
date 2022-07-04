package com.yuanbao.record.web.controller;

import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.UserFeedbackDetail;
import com.yuanbao.record.mbp.vo.UserFeedbackDetailVo;
import com.yuanbao.record.web.service.UserFeedbackDetailClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/userFeedbackDetailClient")
public class UserFeedbackDetailClientController {
    @Autowired
    private UserFeedbackDetailClientService userFeedbackDetailClientService;

    @GetMapping(value = "list")
    public CommonResult<List<UserFeedbackDetailVo>> getUserFeedbackDetail(
            @RequestParam(value = "userFeedbackId") Long userFeedbackId) {
        System.out.println("userFeedbackId" + userFeedbackId);
        List<UserFeedbackDetailVo> userFeedbackDetailVoList = userFeedbackDetailClientService.selectUserFeedbackDetailByUserFeedbackId(userFeedbackId);
        return CommonResult.success(userFeedbackDetailVoList);
    }

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody UserFeedbackDetail userFeedbackDetail) {
        int newId = userFeedbackDetailClientService.insert(userFeedbackDetail);
        if (newId > 0) {
            return CommonResult.success(newId);
        } else {
            return CommonResult.failed();
        }
    }
}
