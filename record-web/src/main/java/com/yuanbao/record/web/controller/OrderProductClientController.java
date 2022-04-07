package com.yuanbao.record.web.controller;

import com.yuanbao.record.common.api.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.OrderProduct;
import com.yuanbao.record.web.service.OrderProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/orderProductClient")
public class OrderProductClientController {
    @Autowired
    private OrderProductClientService orderProductClientService;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody OrderProduct orderProduct) {
        System.out.println("orderProduct" + orderProduct);
        int newId = orderProductClientService.insert(orderProduct);
        if (newId > 0) {
            return CommonResult.success(newId);
        } else {
            return CommonResult.failed();
        }
    }
}
