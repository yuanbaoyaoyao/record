package com.yuanbao.record.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.admin.service.UserOrderService;
import com.yuanbao.record.common.api.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.UserOrder;
import com.yuanbao.record.mbp.vo.UserOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        System.out.println("调用list");
        IPage<UserOrderVo> userOrderVoIPage = userOrderService.selectOrderListSearch(pageNum, pageSize, page, userId, productTitle, productSkusTitle, orderSn, orderStatus);
        return CommonResult.success(userOrderVoIPage);
    }

    @PutMapping(value = "/update")
    public CommonResult update(@RequestBody UserOrder userOrder) {
        System.out.println("userOrder" + userOrder);
        int count = userOrderService.updateByOrderSn(userOrder);
        return CommonResult.success(count);

    }
}
