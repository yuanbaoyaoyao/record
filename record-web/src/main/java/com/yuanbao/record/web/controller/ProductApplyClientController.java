package com.yuanbao.record.web.controller;

import com.yuanbao.record.common.api.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.ProductApply;
import com.yuanbao.record.web.service.ProductApplyClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/client/productApply")
public class ProductApplyClientController {

    @Autowired
    private ProductApplyClientService productApplyClientService;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody ProductApply productApply) {
        System.out.println("执行create1");

        int newId = productApplyClientService.insert(productApply);
        System.out.println("执行create2");
        if (newId > 0) {
            return CommonResult.success(newId);
        } else {
            return CommonResult.failed();
        }
    }
}
