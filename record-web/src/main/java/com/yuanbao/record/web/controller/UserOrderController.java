package com.yuanbao.record.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.common.api.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.UserOrder;
import com.yuanbao.record.mbp.vo.UserOrderVo;
import com.yuanbao.record.web.service.UserOrderClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/client/userOrder")
public class UserOrderController {
    @Autowired
    private UserOrderClientService userOrderClientService;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody UserOrder userOrder) {
        System.out.println("userOrder"+ userOrder);

        int newId = userOrderClientService.insert(userOrder);
        if (newId > 0) {
            return CommonResult.success(newId);
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
                                                        @RequestParam(value = "orderSn", defaultValue = "null") Long orderSn) {
        IPage<UserOrder> page = new Page<>();
        IPage<UserOrderVo> userOrderVoIPage = userOrderClientService.selectOrderListSearch(pageNum, pageSize, page, userId, productTitle, productSkusTitle, orderSn);
        return CommonResult.success(userOrderVoIPage);
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
