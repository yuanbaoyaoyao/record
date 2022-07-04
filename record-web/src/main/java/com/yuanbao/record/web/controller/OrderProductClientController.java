package com.yuanbao.record.web.controller;

import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.OrderProduct;
import com.yuanbao.record.mbp.vo.OrderProductVo;
import com.yuanbao.record.web.service.OrderProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/orderProductClient")
public class OrderProductClientController {
    @Autowired
    private OrderProductClientService orderProductClientService;

    @GetMapping(value = "/list")
    public CommonResult<List<OrderProductVo>> getList(
            @RequestParam(value = "userOrderId", defaultValue = "") Long userOrderId,
            @RequestParam(value = "orderSn", defaultValue = "") Long orderSn,
            @RequestParam(value = "productTitle", defaultValue = "") String productTitle,
            @RequestParam(value = "productSkusTitle", defaultValue = "") String productSkusTitle) {
        List<OrderProductVo> orderProductVoList = orderProductClientService.selectOrderProductList(userOrderId, orderSn, productTitle, productSkusTitle);
        return CommonResult.success(orderProductVoList);
    }

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

    @PostMapping(value = "/createList")
    public CommonResult create(@RequestBody List<OrderProduct> orderProductList) {
        System.out.println("List<OrderProduct>:" + orderProductList);
        for (OrderProduct orderProduct : orderProductList) {
            orderProductClientService.insert(orderProduct);
        }
        return CommonResult.success("创建成功");
    }
}
