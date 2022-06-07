package com.yuanbao.record.search.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.search.mapper.entity.EsProductSkus;
import com.yuanbao.record.search.service.EsProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public CommonResult<IPage<EsProductSkus>> getAllAdminOperationLog(
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "keyword", defaultValue = "null") String keyword) {
        IPage<EsProductSkus> page = new Page<>();
        IPage<EsProductSkus> voPage = esProductService.selectProductSkusListSearchIPage(pageNum, pageSize, page, keyword, keyword);
        return CommonResult.success(voPage);
    }
}
