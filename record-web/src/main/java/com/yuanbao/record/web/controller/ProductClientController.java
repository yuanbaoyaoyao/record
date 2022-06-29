package com.yuanbao.record.web.controller;

import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.mbp.vo.ProductVo;
import com.yuanbao.record.web.service.ProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/productClient")
public class ProductClientController {

    @Autowired
    private ProductClientService productClientService;

    @GetMapping(value = "/listAll")
    public CommonResult<List<ProductVo>> getAllProduct(@RequestParam(value = "productName", defaultValue = "") String productName,
                                                       @RequestParam(value = "type", required = false) Integer type) {
        List<ProductVo> productVoList = productClientService.selectProductListSearchAll(productName, type);
        return CommonResult.success(productVoList);
    }
}
