package com.yuanbao.record.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.admin.annotation.RequiresPermissionsDesc;
import com.yuanbao.record.admin.service.ProductSkusService;
import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.common.annotation.OperationLog;
import com.yuanbao.record.mbp.mapper.entity.ProductSkus;
import com.yuanbao.record.mbp.vo.ProductSkusVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/productSkus")
public class ProductSkusController {
    @Autowired
    private ProductSkusService productSkusService;

    @RequiresPermissionsDesc(menu = {"耗材管理", "耗材列表"}, button = "查询")
    @OperationLog(menu = {"耗材管理", "耗材列表"}, action = "查询")
    @RequiresPermissions("productSkus:list")
    @GetMapping(value = "/list")
    public CommonResult<IPage<ProductSkusVo>> getAllProductSkus(
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "id", defaultValue = "") Long id,
            @RequestParam(value = "title", defaultValue = "null") String title) {
        IPage<ProductSkus> page = new Page<>();
        IPage<ProductSkusVo> voPage = productSkusService.selectProductSkusListSearchIPage(pageNum, pageSize, page, title, id);
        return CommonResult.success(voPage);
    }

    @RequiresPermissionsDesc(menu = {"耗材管理", "耗材列表"}, button = "添加")
    @OperationLog(menu = {"耗材管理", "耗材列表"}, action = "添加")
    @RequiresPermissions("productSkus:create")
    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody ProductSkus productSkus) {
        int newId = productSkusService.insert(productSkus);
        if (newId > 0) {
            return CommonResult.success(newId);
        } else {
            return CommonResult.failed();
        }
    }

    @RequiresPermissionsDesc(menu = {"耗材管理", "耗材列表"}, button = "删除")
    @OperationLog(menu = {"耗材管理", "耗材列表"}, action = "删除")
    @RequiresPermissions("productSkus:delete")
    @DeleteMapping(value = "/delete")
    public CommonResult delete(@RequestBody ProductSkus productSkus) {
        long tempId = productSkus.getId();
        int count = productSkusService.deleteByPrimaryKey(tempId);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @RequiresPermissionsDesc(menu = {"耗材管理", "耗材列表"}, button = "修改")
    @OperationLog(menu = {"耗材管理", "耗材列表"}, action = "修改")
    @RequiresPermissions("productSkus:update")
    @PutMapping(value = "/update")
    public CommonResult update(@RequestBody ProductSkus productSkus) {
        int count = productSkusService.updateByPrimaryKey(productSkus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
