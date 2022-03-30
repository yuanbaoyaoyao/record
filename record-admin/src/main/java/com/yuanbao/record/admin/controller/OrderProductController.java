package com.yuanbao.record.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.admin.service.OrderProductService;
import com.yuanbao.record.common.api.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.OrderProduct;
import com.yuanbao.record.mbp.vo.OrderProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/orderProduct")
public class OrderProductController {
    @Autowired
    private OrderProductService orderProductService;

    @GetMapping(value = "/list")
    public CommonResult<List<OrderProductVo>> getAllOrderProductIPage(@RequestParam(value = "userOrderId", required = false) Long userOrderId,
                                                                      @RequestParam(value = "orderSn", required = false) Long orderSn,
                                                                      @RequestParam(value = "productTitle", required = false) String productTitle,
                                                                      @RequestParam(value = "productSkusTitle", required = false) String productSkusTitle) {
        System.out.println("orderSn:" + orderSn);
        List<OrderProductVo> orderProductVoList = orderProductService.selectOrderProductList(userOrderId, orderSn, productTitle, productSkusTitle);
        return CommonResult.success(orderProductVoList);
    }

    @GetMapping(value = "/dateList")
    public CommonResult<IPage<OrderProductVo>> getAllDateOrderProductIPage(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                           @RequestParam(value = "userOrderId", required = false) Long userOrderId,
                                                                           @RequestParam(value = "orderSn", required = false) Long orderSn,
                                                                           @RequestParam(value = "receiver", required = false) String receiver,
                                                                           @RequestParam(value = "productTitle", required = false) String productTitle,
                                                                           @RequestParam(value = "productSkusTitle", required = false) String productSkusTitle,
                                                                           @RequestParam(value = "dateState", defaultValue = "1", required = false) Integer dateState,
                                                                           @RequestParam(value = "specifiedTime1", required = false)
                                                                           @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                                                   String specifiedTime1,
                                                                           @RequestParam(value = "specifiedTime2", required = false)
                                                                           @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                                                   String specifiedTime2) {
        IPage<OrderProduct> page = new Page<>();
        IPage<OrderProductVo> orderProductVoIPage = orderProductService.selectOrderProductListDateSearchStatus(pageNum, pageSize, page, userOrderId, orderSn, receiver,productTitle, productSkusTitle, dateState, specifiedTime1, specifiedTime2);
        return CommonResult.success(orderProductVoIPage);
    }

    @GetMapping(value = "/dateProductCountList")
    public CommonResult<IPage<OrderProductVo>> getAllDateOrderProductCountIPage(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                           @RequestParam(value = "productTitle", required = false) String productTitle,
                                                                           @RequestParam(value = "productSkusTitle", required = false) String productSkusTitle,
                                                                           @RequestParam(value = "dateState", defaultValue = "1", required = false) Integer dateState,
                                                                           @RequestParam(value = "specifiedTime1", required = false)
                                                                           @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                                                   String specifiedTime1,
                                                                           @RequestParam(value = "specifiedTime2", required = false)
                                                                           @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                                                   String specifiedTime2) {
        IPage<OrderProduct> page = new Page<>();
        IPage<OrderProductVo> orderProductVoIPage = orderProductService.selectProductListDateCountSearch(pageNum, pageSize, page,productTitle, productSkusTitle, dateState, specifiedTime1, specifiedTime2);
        return CommonResult.success(orderProductVoIPage);
    }

    @GetMapping(value = "/dateProductCountAllList")
    public CommonResult<List<OrderProductVo>> getAllDateOrderProductCountAllList(
                                                                                @RequestParam(value = "productTitle", required = false) String productTitle,
                                                                                @RequestParam(value = "productSkusTitle", required = false) String productSkusTitle,
                                                                                @RequestParam(value = "dateState", defaultValue = "1", required = false) Integer dateState,
                                                                                @RequestParam(value = "specifiedTime1", required = false)
                                                                                @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                                                        String specifiedTime1,
                                                                                @RequestParam(value = "specifiedTime2", required = false)
                                                                                @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                                                        String specifiedTime2) {
        List<OrderProductVo> orderProductVoList = orderProductService.selectProductListDateCountSearchAllList(productTitle, productSkusTitle, dateState, specifiedTime1, specifiedTime2);
        return CommonResult.success(orderProductVoList);
    }
}
