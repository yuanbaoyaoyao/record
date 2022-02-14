package com.yuanbao.record.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.admin.service.AdminOperationLogService;
import com.yuanbao.record.common.api.CommonResult;
import com.yuanbao.record.mbp.vo.AdminOperationLogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("adminOperationLog")
public class AdminOperationLogController {
    @Autowired
    private AdminOperationLogService adminOperationLogService;

    @GetMapping(value = "/list")
    public CommonResult<IPage<AdminOperationLogVo>> getAllAdminUser(
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "keyword", defaultValue = "null") String keyword) {
        IPage<AdminOperationLogVo> page = new Page<>();
        IPage<AdminOperationLogVo> adminUserIPage = adminOperationLogService.selectAdminOperationLogListSearch(pageNum, pageSize, page, keyword);
        return CommonResult.success(adminUserIPage);
    }
}
