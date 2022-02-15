package com.yuanbao.record.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.admin.service.AdminUserService;
import com.yuanbao.record.common.api.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.AdminUser;
import com.yuanbao.record.mbp.vo.AdminUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("adminUser")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    @GetMapping(value = "/list")
    public CommonResult<IPage<AdminUserVo>> getAllAdminUser(
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "keyword", defaultValue = "null") String keyword) {
//        IPage<AdminUserVo> voPage = new Page<>();
//        List<AdminUserVo> adminUserVoList = new ArrayList<>();
//        IPage<AdminUser> adminUserIPage = adminUserService.selectAdminListSearch(pageNum, pageSize, page, keyword);
//        List<AdminUser> adminUserList = adminUserIPage.getRecords();
//        for (AdminUser adminUser : adminUserList) {
//            AdminUserVo adminUserVo = AdminUserVoMapper.adminuservomapper.Trans(adminUser);
//            adminUserVoList.add(adminUserVo);
//        }
//        voPage.setRecords(adminUserVoList);
//        voPage.setCurrent(pageNum);
//        voPage.setSize(pageSize);
//        voPage.setTotal(adminUserIPage.getTotal());
        IPage<AdminUser> page = new Page<>();
        IPage<AdminUserVo> voPage = adminUserService.selectAdminListSearch(pageNum, pageSize, page, keyword);
        return CommonResult.success(voPage);
    }

//    @GetMapping(value = "/listNoPage")
//    public CommonResult<List<AdminUserVo>> getAllAdminUserNoPage(
//            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
//            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
//            @RequestParam(value = "keyword", defaultValue = "null") String keyword) {
//        List<AdminUser> list = new ArrayList<>();
//        List<AdminUserVo> adminUserVoList = new ArrayList<>();
//        List<AdminUser> adminUserList = adminUserService.selectAdminListSearch(list, keyword);
//        for (AdminUser adminUser : adminUserList) {
//            AdminUserVo adminUserVo = AdminUserVoMapper.adminuservomapper.Trans(adminUser);
//            adminUserVoList.add(adminUserVo);
//        }
//        return CommonResult.success(adminUserVoList);
//    }

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody AdminUser adminUser) {
        int newId = adminUserService.insert(adminUser);
        if (newId > 0) {
            return CommonResult.success(newId);
        } else {
            return CommonResult.failed();
        }
    }

    @PostMapping(value = "/delete")
//    public CommonResult delete(@RequestParam("id") Long id){
    public CommonResult delete(@RequestBody AdminUser adminUser) {
        long tempId = adminUser.getId();
        int count = adminUserService.deleteByPrimaryKey(tempId);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @PostMapping(value = "/update")
    public CommonResult update(@RequestBody AdminUser adminUser) {
        int count = adminUserService.updateByPrimaryKey(adminUser);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
