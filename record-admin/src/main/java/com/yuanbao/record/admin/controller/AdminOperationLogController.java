package com.yuanbao.record.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.admin.service.AdminOperationLogService;
import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.AdminOperationLog;
import com.yuanbao.record.mbp.vo.AdminOperationLogVo;
import com.yuanbao.record.shiro.annotation.RequiresPermissionsDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/adminOperationLog")
public class AdminOperationLogController {
    @Autowired
    private AdminOperationLogService adminOperationLogService;

    @RequiresPermissionsDesc(menu = {"权限管理", "操作日志"}, button = "查询")
//    @RequiresPermissions("adminOperationLog:list")
    @GetMapping(value = "/list")
    public CommonResult<IPage<AdminOperationLogVo>> getAllAdminOperationLog(
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "keyword", defaultValue = "null") String keyword) {
        IPage<AdminOperationLog> page = new Page<>();
        IPage<AdminOperationLogVo> voPage = adminOperationLogService.selectAdminOperationLogListSearch(pageNum, pageSize, page, keyword);
        return CommonResult.success(voPage);
    }
}
