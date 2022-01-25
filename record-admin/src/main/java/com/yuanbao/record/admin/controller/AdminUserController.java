package com.yuanbao.record.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.admin.service.AdminUserService;
import com.yuanbao.record.mbp.entity.AdminUser;
import com.yuanbao.record.mbp.vo.AdminUserVo;
import com.yuanbao.recordcommon.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("adminUser")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    @GetMapping(value = "/list")
    @ResponseBody
    public CommonResult<IPage<AdminUserVo>> getAllAdminUser(
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "keyword",defaultValue = "null") String keyword) {
        IPage<AdminUser> page = new Page<AdminUser>();
        IPage<AdminUserVo> adminUserIPage = adminUserService.selectAdminListSearch(pageNum, pageSize, page,keyword);
        return CommonResult.success(adminUserIPage);
    }

//    @GetMapping(value = "/list")
//    @ResponseBody
//    public CommonResult<IPage<AdminUserVo>> getAllAdminUserSearch(
//            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
//            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
//        IPage<AdminUser> page = new Page<AdminUser>();
//        IPage<AdminUserVo> adminUserIPage = adminUserService.selectAdminList(pageNum, pageSize, page);
//        return CommonResult.success(adminUserIPage);
//    }
}
