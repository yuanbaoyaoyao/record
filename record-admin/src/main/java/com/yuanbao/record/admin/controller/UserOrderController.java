package com.yuanbao.record.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.admin.service.UserOrderService;
import com.yuanbao.record.common.api.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.UserOrder;
import com.yuanbao.record.mbp.vo.UserOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/userOrder")
public class UserOrderController {

    @Autowired
    private UserOrderService userOrderService;

    @GetMapping(value = "/list")
    public CommonResult<IPage<UserOrderVo>> getAllOrderIPage(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
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
    public CommonResult<IPage<UserOrderVo>> getDateOrderIPage(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                              @RequestParam(value = "userId", required = false) Long userId,
                                                              @RequestParam(value = "receiver", required = false) String receiver,
                                                              @RequestParam(value = "orderSn", required = false) Long orderSn,
                                                              @RequestParam(value = "dateState", defaultValue = "1", required = false) Integer dateState,
                                                              @RequestParam(value = "specifiedTime1", required = false)
                                                              @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                                      String specifiedTime1,
                                                              @RequestParam(value = "specifiedTime2", required = false)
                                                              @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                                      String specifiedTime2) {
        IPage<UserOrder> page = new Page<>();
        IPage<UserOrderVo> userOrderVoIPage = userOrderService.selectOrderListDateSearch(pageNum, pageSize, page, userId, dateState, receiver, orderSn, specifiedTime1, specifiedTime2);
        return CommonResult.success(userOrderVoIPage);
    }


    @GetMapping(value = "/dateListCount")
    public CommonResult<IPage<UserOrderVo>> getAllDateProductIPage(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                   @RequestParam(value = "userId", required = false) Long userId,
                                                                   @RequestParam(value = "receiver", required = false) String receiver,
                                                                   @RequestParam(value = "dateState", defaultValue = "1", required = false) Integer dateState,
                                                                   @RequestParam(value = "specifiedTime1", required = false)
                                                                   @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                                           String specifiedTime1,
                                                                   @RequestParam(value = "specifiedTime2", required = false)
                                                                   @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                                           String specifiedTime2) {
        IPage<UserOrder> page = new Page<>();
        IPage<UserOrderVo> userOrderVoIPage = userOrderService.selectOrderListDateCountSearch(pageNum, pageSize, page, userId, dateState, receiver, specifiedTime1, specifiedTime2);
        return CommonResult.success(userOrderVoIPage);
    }

    @GetMapping(value = "/dateListNoGroup")
    public CommonResult<IPage<UserOrderVo>> getAllDateOrderIPageNoGroup(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                        @RequestParam(value = "userId", required = false) Long userId,
                                                                        @RequestParam(value = "receiver", required = false) String receiver,
                                                                        @RequestParam(value = "dateState", defaultValue = "1", required = false) Integer dateState,
                                                                        @RequestParam(value = "specifiedTime1", required = false)
                                                                        @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                                                String specifiedTime1,
                                                                        @RequestParam(value = "specifiedTime2", required = false)
                                                                        @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                                                String specifiedTime2) {
        IPage<UserOrder> page = new Page<>();
        IPage<UserOrderVo> userOrderVoIPage = userOrderService.selectOrderListDateCountSearchNoGroup(pageNum, pageSize, page, userId, receiver, dateState, specifiedTime1, specifiedTime2);
        return CommonResult.success(userOrderVoIPage);
    }

    @GetMapping(value = "/dateListAll")
    public CommonResult<List<UserOrderVo>> getAllDateOrderAllList(
            @RequestParam(value = "userId", required = false) Long userId,
            @RequestParam(value = "receiver", required = false) String receiver,
            @RequestParam(value = "dateState", defaultValue = "1", required = false) Integer dateState,
            @RequestParam(value = "specifiedTime1", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd")
                    String specifiedTime1,
            @RequestParam(value = "specifiedTime2", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd")
                    String specifiedTime2) {
        List<UserOrderVo> userOrderList = userOrderService.selectOrderListDateCountSearchAllList(userId, receiver, dateState, specifiedTime1, specifiedTime2);
        return CommonResult.success(userOrderList);
    }

    @GetMapping(value = "/dateListAllDay")
    public CommonResult<List<UserOrderVo>> getAllDateOrderAllListDay(
            @RequestParam(value = "userId", required = false) Long userId,
            @RequestParam(value = "receiver", required = false) String receiver,
            @RequestParam(value = "dateState", defaultValue = "1", required = false) Integer dateState,
            @RequestParam(value = "specifiedTime1", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd")
                    String specifiedTime1,
            @RequestParam(value = "specifiedTime2", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd")
                    String specifiedTime2) {
        List<UserOrderVo> userOrderList = userOrderService.selectOrderListDateCountSearchAllListDay(userId, receiver, dateState, specifiedTime1, specifiedTime2);
        return CommonResult.success(userOrderList);
    }

    @GetMapping(value = "/dateListAllMonth")
    public CommonResult<List<UserOrderVo>> getAllDateOrderAllListMonth(
            @RequestParam(value = "userId", required = false) Long userId,
            @RequestParam(value = "receiver", required = false) String receiver,
            @RequestParam(value = "dateState", defaultValue = "1", required = false) Integer dateState,
            @RequestParam(value = "specifiedTime1", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd")
                    String specifiedTime1,
            @RequestParam(value = "specifiedTime2", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd")
                    String specifiedTime2) {
        List<UserOrderVo> userOrderList = userOrderService.selectOrderListDateCountSearchAllListMonth(userId, receiver, dateState, specifiedTime1, specifiedTime2);
        return CommonResult.success(userOrderList);
    }

    @PutMapping(value = "/update")
    public CommonResult update(@RequestBody UserOrder userOrder) {
        System.out.println("userOrder" + userOrder);
        int count = userOrderService.updateByOrderSn(userOrder);
        return CommonResult.success(count);

    }
}
