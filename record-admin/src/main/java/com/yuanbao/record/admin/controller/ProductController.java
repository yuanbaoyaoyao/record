package com.yuanbao.record.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.admin.annotation.RequiresPermissionsDesc;
import com.yuanbao.record.admin.service.ProductService;
import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.common.annotation.OperationLog;
import com.yuanbao.record.mbp.mapper.entity.Product;
import com.yuanbao.record.mbp.vo.ProductVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequiresPermissionsDesc(menu = {"耗材管理", "耗材类别"}, button = "分页查询")
    @OperationLog(menu = {"耗材管理", "耗材类别"}, action = "分页查询")
    @RequiresPermissions("product:list")
    @GetMapping(value = "/list")
    public CommonResult<IPage<ProductVo>> getAllProductIPage(
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "title", defaultValue = "null") String title) {
        IPage<Product> page = new Page<>();
        IPage<ProductVo> voPage = productService.selectProductListSearch(pageNum, pageSize, page, title);
        return CommonResult.success(voPage);
    }

    @RequiresPermissionsDesc(menu = {"耗材管理", "耗材类别"}, button = "查询")
    @OperationLog(menu = {"耗材管理", "耗材类别"}, action = "查询")
    @RequiresPermissions("product:listAll")
    @GetMapping(value = "/listAll")
    public CommonResult<List<ProductVo>> getAllProduct() {
        List<ProductVo> productVoList = productService.selectProductList();
        return CommonResult.success(productVoList);
    }

    @RequiresPermissionsDesc(menu = {"耗材管理", "耗材类别"}, button = "添加")
    @OperationLog(menu = {"耗材管理", "耗材类别"}, action = "添加")
    @RequiresPermissions("product:create")
    @PostMapping(value = "/create")
    public CommonResult<?> create(@RequestBody Product product) {
        int newId = productService.insert(product);
        if (newId > 0) {
            return CommonResult.success(newId);
        } else {
            return CommonResult.failed();
        }
    }

    @RequiresPermissionsDesc(menu = {"耗材管理", "耗材类别"}, button = "删除")
    @OperationLog(menu = {"耗材管理", "耗材类别"}, action = "删除")
    @RequiresPermissions("product:delete")
    @DeleteMapping(value = "/delete")
    public CommonResult delete(@RequestBody Product product) {
        long tempId = product.getId();
        int count = productService.deleteByPrimaryKey(tempId);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @RequiresPermissionsDesc(menu = {"耗材管理", "耗材类别"}, button = "修改")
    @OperationLog(menu = {"耗材管理", "耗材类别"}, action = "修改")
    @RequiresPermissions("product:update")
    @PutMapping(value = "/update")
    public CommonResult update(@RequestBody Product product) {
        int count = productService.updateByPrimaryKey(product);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
