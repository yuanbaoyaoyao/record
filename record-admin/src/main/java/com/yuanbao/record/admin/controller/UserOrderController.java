package com.yuanbao.record.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.admin.service.UserOrderService;
import com.yuanbao.record.common.api.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.UserOrder;
import com.yuanbao.record.mbp.vo.UserOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@CrossOrigin
@RequestMapping("/userOrder")
public class UserOrderController {

    @Autowired
    private UserOrderService userOrderService;

    @GetMapping(value = "/list")
    public CommonResult<IPage<UserOrderVo>> getAllOrder(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "userId", required = false) Long userId,
                                                        @RequestParam(value = "productTitle", defaultValue = "") String productTitle,
                                                        @RequestParam(value = "productSkusTitle", defaultValue = "") String productSkusTitle,
                                                        @RequestParam(value = "orderSn", required = false) Long orderSn,
                                                        @RequestParam(value = "orderStatus", required = false) Integer orderStatus) {
        IPage<UserOrder> page = new Page<>();
        IPage<UserOrderVo> userOrderVoIPage = userOrderService.selectOrderListSearch(pageNum, pageSize, page, userId, productTitle, productSkusTitle, orderSn, orderStatus);
        return CommonResult.success(userOrderVoIPage);
    }

    @GetMapping(value = "/dateList")
    public CommonResult<IPage<UserOrderVo>> getAllDateOrder(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                            @RequestParam(value = "userId", required = false) Long userId,
                                                            @RequestParam(value = "dateState",defaultValue = "1", required = false) Integer dateState,
                                                            @RequestParam(value = "specifiedTime1", required = false) LocalDateTime specifiedTime1,
                                                            @RequestParam(value = "specifiedTime2", required = false) LocalDateTime specifiedTime2) {
        IPage<UserOrder> page = new Page<>();
        IPage<UserOrderVo> userOrderVoIPage = userOrderService.selectOrderListDateSearch(pageNum, pageSize, page, userId, dateState, specifiedTime1, specifiedTime2);
        return CommonResult.success(userOrderVoIPage);
    }

    @PutMapping(value = "/update")
    public CommonResult update(@RequestBody UserOrder userOrder) {
        System.out.println("userOrder" + userOrder);
        int count = userOrderService.updateByOrderSn(userOrder);
        return CommonResult.success(count);

    }
}
