package com.yuanbao.record.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.UserFeedback;
import com.yuanbao.record.mbp.vo.UserFeedbackVo;
import com.yuanbao.record.web.service.UserFeedbackClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/userFeedbackClient")
public class UserFeedbackClientController {
    @Autowired
    private UserFeedbackClientService userFeedbackClientService;

    @GetMapping(value = "list")
    public CommonResult<IPage<UserFeedbackVo>> getUserFeedback(
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "userId", defaultValue = "null") Long userId) {
        IPage<UserFeedback> page = new Page<>();
        IPage<UserFeedbackVo> voPage = userFeedbackClientService.selectListByUserId(pageNum, pageSize, page, userId);
        return CommonResult.success(voPage);
    }

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody UserFeedback userFeedback) {
        int newId = userFeedbackClientService.insert(userFeedback);
        if (newId > 0) {
            return CommonResult.success("创建成功");
        } else {
            return CommonResult.failed();
        }
    }

    @PutMapping(value = "/updateFinished")
    public CommonResult updateFinished(@RequestBody UserFeedback userFeedback) {
        int count = userFeedbackClientService.updateFinished(userFeedback);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

}
