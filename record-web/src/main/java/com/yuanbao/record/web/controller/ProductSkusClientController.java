package com.yuanbao.record.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.ProductSkus;
import com.yuanbao.record.mbp.vo.ProductSkusVo;
import com.yuanbao.record.web.service.ProductSkusClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/productSkusClient")
public class ProductSkusClientController {
    @Autowired
    private ProductSkusClientService productSkusClientService;

    @GetMapping(value = "/listSearchIPage")
    public CommonResult<IPage<ProductSkusVo>> getAllProductSkusIPage(
            @RequestParam(value = "pageSize", defaultValue = "8") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "id", defaultValue = "") Long id,
            @RequestParam(value = "productName", defaultValue = "null") String productName,
            @RequestParam(value = "productSkusName", defaultValue = "null") String productSkusName) {
        IPage<ProductSkus> page = new Page<>();
        IPage<ProductSkusVo> voPage = productSkusClientService.selectProductSkusListSearchIPage(pageNum, pageSize, page, productName, id, productSkusName);
        return CommonResult.success(voPage);
    }

    @GetMapping(value = "/listByTypeIPage")
    public CommonResult<IPage<ProductSkusVo>> getAllProductSkusByTypeIPage(
            @RequestParam(value = "pageSize", defaultValue = "8") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "type", required = false) Integer type) {
        IPage<ProductSkus> page = new Page<>();
        IPage<ProductSkusVo> voPage = productSkusClientService.selectProductSkusListByProductTypeIPage(pageNum, pageSize, page, type);
        return CommonResult.success(voPage);
    }

    @GetMapping(value = "/listCountByProductIdAndTypeIPage")
    public CommonResult<IPage<ProductSkusVo>> getAllProductSkusCountByProductIdAndTypeIPage(
            @RequestParam(value = "pageSize", defaultValue = "8") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "productId") Long productId,
            @RequestParam(value = "type", defaultValue = "1") Integer type,
            @RequestParam(value = "userId", required = false) Long userId) {
        IPage<ProductSkus> page = new Page<>();
        IPage<ProductSkusVo> voPage = productSkusClientService.selectProductSkusListCountByProductIdAndTypeIPage(pageNum, pageSize, page, productId, type, userId);
        return CommonResult.success(voPage);
    }

    @GetMapping(value = "/listSearch")
    public CommonResult<List<ProductSkusVo>> getAllProductSkus(
            @RequestParam(value = "id", defaultValue = "") Long id,
            @RequestParam(value = "productId", defaultValue = "") Long productId,
            @RequestParam(value = "title", defaultValue = "null") String title,
            @RequestParam(value = "productSkusName", defaultValue = "null") String productSkusName) {
        List<ProductSkusVo> productSkusVoList = productSkusClientService.selectProductSkusListSearch(title, id, productId, productSkusName);
        return CommonResult.success(productSkusVoList);
    }

    @GetMapping(value = "/listLimit")
    public CommonResult<List<ProductSkusVo>> getAllProductSkusLimit() {
        List<ProductSkusVo> productSkusVoList = productSkusClientService.selectProductSkusListLimit();
        return CommonResult.success(productSkusVoList);
    }

    @GetMapping(value = "/listLimitByNumber")
    public CommonResult<List<ProductSkusVo>> getAllProductSkusLimitByNumber(
            @RequestParam(value = "number", defaultValue = "null") Integer number
    ) {
        List<ProductSkusVo> productSkusVoList = productSkusClientService.selectProductSkusListLimitNumber(number);
        return CommonResult.success(productSkusVoList);
    }

    @PutMapping(value = "/update")
    public CommonResult update(@RequestBody ProductSkus productSkus) {
        int count = productSkusClientService.updateByPrimaryKey(productSkus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
