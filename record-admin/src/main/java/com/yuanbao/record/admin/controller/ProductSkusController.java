package com.yuanbao.record.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.admin.service.ProductSkusService;
import com.yuanbao.record.common.api.CommonResult;
import com.yuanbao.record.mbp.entity.ProductSkus;
import com.yuanbao.record.mbp.vo.ProductSkusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("productSkus")
public class ProductSkusController {
    @Autowired
    private ProductSkusService productSkusService;

    @GetMapping(value = "/list")
    public CommonResult<IPage<ProductSkusVo>> getAllProductSkus(
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "keyword", defaultValue = "null") String keyword) {
        IPage<ProductSkusVo> page = new Page<>();
        IPage<ProductSkusVo> productSkusIPage = productSkusService.selectProductSkusListSearch(pageNum, pageSize, page, keyword);
        return CommonResult.success(productSkusIPage);
    }

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody ProductSkus productSkus) {
        int newId = productSkusService.insert(productSkus);
        if (newId > 0) {
            return CommonResult.success(newId);
        } else {
            return CommonResult.failed();
        }
    }

    @PostMapping(value = "/delete")
    public CommonResult delete(@RequestBody ProductSkus productSkus){
        long tempId = productSkus.getId();
        int count = productSkusService.deleteByPrimaryKey(tempId);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @PostMapping(value = "/update")
    public CommonResult update(@RequestBody ProductSkus productSkus){
        int count = productSkusService.updateByPrimaryKey(productSkus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
