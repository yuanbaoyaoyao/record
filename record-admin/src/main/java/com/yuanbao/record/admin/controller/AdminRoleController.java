package com.yuanbao.record.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.admin.service.AdminRoleService;
import com.yuanbao.record.common.api.CommonResult;
import com.yuanbao.record.mbp.vo.AdminRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("adminRole")
public class AdminRoleController {
    @Autowired
    private AdminRoleService adminRoleService;

    @GetMapping(value = "list")
    public CommonResult<IPage<AdminRoleVo>> getAllAdminRole(
        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
        @RequestParam(value = "keyword",defaultValue = "null") String keyword) {
            IPage<AdminRoleVo> page = new Page<>();
            IPage<AdminRoleVo> adminRoleVoIPage = adminRoleService.selectRoleList(pageNum, pageSize, page,keyword);
            return CommonResult.success(adminRoleVoIPage);
    }

}
