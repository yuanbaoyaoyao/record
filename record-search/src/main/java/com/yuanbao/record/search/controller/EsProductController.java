package com.yuanbao.record.search.controller;

import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.search.mapper.entity.EsProductSkus;
import com.yuanbao.record.search.service.EsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/esProduct")
public class EsProductController {
    @Autowired
    private EsProductService esProductService;

    @ResponseBody
    @PostMapping(value = "/importAllInfo")
    public CommonResult importAllInfo() {
        boolean isInput = esProductService.importAllInfo();
        return CommonResult.success(isInput);
    }

    @GetMapping(value = "/search")
    @ResponseBody
    public CommonResult<Page<EsProductSkus>> search(
            @RequestParam(value = "pageSize", defaultValue = "8") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "keyword", defaultValue = "null") String keyword) {
        System.out.println("keyword:"+keyword);
        Page<EsProductSkus> productSkusPage = esProductService.selectProductSkusListSearchIPage(pageNum, pageSize, keyword, keyword);
        return CommonResult.success(productSkusPage);
    }

    @GetMapping(value = "/searchByStock")
    @ResponseBody
    public CommonResult<Page<EsProductSkus>> searchByStock(
            @RequestParam(value = "pageSize", defaultValue = "8") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "keyword", defaultValue = "null") String keyword) {
        Page<EsProductSkus> productSkusPage = esProductService.selectProductSkusListOrderByStockSearchIPage(pageNum, pageSize, keyword, keyword);
        return CommonResult.success(productSkusPage);
    }
}
