package com.yuanbao.record.admin.controller;

import com.yuanbao.record.mbp.entity.AdminRole;
import com.yuanbao.record.mbp.mapper.AdminRoleMapper;
import com.yuanbao.recordcommon.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("adminRole")
public class AdminRoleController {
    @Autowired
    private AdminRoleMapper adminRoleMapper;

    @GetMapping(value = "list")
    @ResponseBody
    public CommonResult<List<AdminRole>> getAllAdminRole(){
        List<AdminRole> adminRoles = adminRoleMapper.selectList(null);
        return CommonResult.success(adminRoles);
    }

}
