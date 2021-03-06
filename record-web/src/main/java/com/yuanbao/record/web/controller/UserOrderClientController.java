package com.yuanbao.record.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.UserOrder;
import com.yuanbao.record.mbp.vo.UserOrderVo;
import com.yuanbao.record.web.service.UserOrderClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/userOrderClient")
public class UserOrderClientController {
    @Autowired
    private UserOrderClientService userOrderClientService;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody UserOrder userOrder) {

        userOrderClientService.insert(userOrder);
        Long newId = userOrder.getId();
        Long newOrderSn = userOrder.getOrderSn();
        Map<String, Long> data = new HashMap<>();
        data.put("id", newId);
        data.put("orderSn", newOrderSn);
        System.out.println("newId:" + newId);
        if (newId > 0) {
            return CommonResult.success(data);
        } else {
            return CommonResult.failed();
        }
    }

    @GetMapping(value = "/list")
    public CommonResult<IPage<UserOrderVo>> getAllOrder(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "userId") Long userId,
                                                        @RequestParam(value = "productTitle", defaultValue = "null") String productTitle,
                                                        @RequestParam(value = "productSkusTitle", defaultValue = "null") String productSkusTitle,
                                                        @RequestParam(value = "orderSn", required = false) Long orderSn,
                                                        @RequestParam(value = "id", required = false) Long id,
                                                        @RequestParam(value = "orderStatus", required = false) Integer orderStatus) {
        IPage<UserOrder> page = new Page<>();
        IPage<UserOrderVo> userOrderVoIPage = userOrderClientService.selectOrderListSearch(pageNum, pageSize, page, userId, productTitle, productSkusTitle, orderSn,id, orderStatus);
        return CommonResult.success(userOrderVoIPage);
    }

    @PutMapping(value = "/update")
    public CommonResult update(@RequestBody UserOrder userOrder) {
        int count = userOrderClientService.updateByOrderSn(userOrder);
        return CommonResult.success(count);
    }


    @DeleteMapping(value = "/delete")
    public CommonResult delete(@RequestBody UserOrder userOrder) {
        long tempId = userOrder.getId();
        int count = userOrderClientService.deleteByPrimaryKey(tempId);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
