package com.yuanbao.record.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.admin.service.AdminRoleService;
import com.yuanbao.record.common.api.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.AdminRole;
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
        IPage<AdminRole> page = new Page<>();
        IPage<AdminRoleVo> voPage = adminRoleService.selectRoleList(pageNum, pageSize, page, keyword);
        return CommonResult.success(voPage);
    }

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody AdminRole adminRole) {
        int newId = adminRoleService.insert(adminRole);
        if (newId > 0) {
            return CommonResult.success(newId);
        } else {
            return CommonResult.failed();
        }
    }

    @PostMapping(value = "/delete")
    public CommonResult delete(@RequestBody AdminRole adminRole){
        long tempId = adminRole.getId();
        int count = adminRoleService.deleteByPrimaryKey(tempId);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @PostMapping(value = "/update")
    public CommonResult update(@RequestBody AdminRole adminRole){
        int count = adminRoleService.updateByPrimaryKey(adminRole);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
