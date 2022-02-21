package com.yuanbao.record.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.admin.service.ProductService;
import com.yuanbao.record.common.api.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.Product;
import com.yuanbao.record.mbp.vo.ProductVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequiresPermissions("product:list")
    @GetMapping(value = "/list")
    public CommonResult<IPage<ProductVo>> getAllProduct(
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "keyword", defaultValue = "null") String keyword) {
        IPage<Product> page = new Page<>();
        IPage<ProductVo> voPage = productService.selectProductListSearch(pageNum, pageSize, page, keyword);
        return CommonResult.success(voPage);
    }

    @RequiresPermissions("product:create")
    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Product product) {
        int newId = productService.insert(product);
        if (newId > 0) {
            return CommonResult.success(newId);
        } else {
            return CommonResult.failed();
        }
    }

    @RequiresPermissions("product:delete")
    @DeleteMapping(value = "/delete")
    public CommonResult delete(@RequestBody Product product){
        long tempId = product.getId();
        int count = productService.deleteByPrimaryKey(tempId);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @RequiresPermissions("product:update")
    @PutMapping(value = "/update")
    public CommonResult update(@RequestBody Product product){
        int count = productService.updateByPrimaryKey(product);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
