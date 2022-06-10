package com.yuanbao.record.admin.controller;

import com.yuanbao.record.admin.annotation.RequiresPermissionsDesc;
import com.yuanbao.record.admin.service.AnnouncementService;
import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.common.annotation.OperationLog;
import com.yuanbao.record.mbp.mapper.entity.Announcement;
import com.yuanbao.record.mbp.vo.AnnouncementVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/announcement")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @RequiresPermissionsDesc(menu = {"页面管理", "公告"}, button = "查询")
    @OperationLog(menu = {"页面管理", "公告"}, action = "查询")
    @RequiresPermissions("announcement:list")
    @GetMapping(value = "/list")
    public CommonResult<List<AnnouncementVo>> getAllAdminUser() {
        List<AnnouncementVo> announcementVoList = announcementService.selectAll();
        return CommonResult.success(announcementVoList);
    }

    @RequiresPermissionsDesc(menu = {"页面管理", "公告"}, button = "添加")
    @OperationLog(menu = {"页面管理", "公告"}, action = "添加")
    @RequiresPermissions("announcement:create")
    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Announcement announcement) {
        int newId = announcementService.insert(announcement);
        if (newId > 0) {
            return CommonResult.success(newId);
        } else {
            return CommonResult.failed();
        }
    }

    @RequiresPermissionsDesc(menu = {"页面管理", "公告"}, button = "删除")
    @OperationLog(menu = {"页面管理", "公告"}, action = "删除")
    @RequiresPermissions("announcement:delete")
    @DeleteMapping(value = "/delete")
    public CommonResult delete(@RequestBody Announcement announcement) {
        long tempId = announcement.getId();
        int count = announcementService.deleteByPrimaryKey(tempId);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @RequiresPermissionsDesc(menu = {"页面管理", "公告"}, button = "修改")
    @OperationLog(menu = {"页面管理", "公告"}, action = "修改")
    @RequiresPermissions("announcement:update")
    @PutMapping(value = "/update")
    public CommonResult update(@RequestBody Announcement announcement) {
        int count = announcementService.updateByPrimaryKey(announcement);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
