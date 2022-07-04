package com.yuanbao.record.web.controller;

import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.mbp.vo.ProductSkusDetailsVo;
import com.yuanbao.record.web.service.ProductSkusDetailsClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/productSkusDetailsClient")
public class ProductSkusDetailsClientController {

    @Autowired
    private ProductSkusDetailsClientService productSkusDetailsClientService;

    @GetMapping(value = "/list")
    public CommonResult<List<ProductSkusDetailsVo>> getList(
            @RequestParam(value = "productSkusId") Long productSkusId) {
        List<ProductSkusDetailsVo> productSkusDetailsVoList = productSkusDetailsClientService.selectList(productSkusId);
        return CommonResult.success(productSkusDetailsVoList);
    }
}
