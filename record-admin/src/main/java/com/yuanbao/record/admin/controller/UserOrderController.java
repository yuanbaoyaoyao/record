package com.yuanbao.record.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.admin.annotation.RequiresPermissionsDesc;
import com.yuanbao.record.admin.service.UserOrderService;
import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.common.annotation.OperationLog;
import com.yuanbao.record.mbp.mapper.entity.UserOrder;
import com.yuanbao.record.mbp.vo.UserOrderVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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

    @RequiresPermissionsDesc(menu = {"需求管理", "需求列表"}, button = "查询")
    @OperationLog(menu = {"需求管理", "需求列表"}, action = "查询")
    @RequiresPermissions("userOrder:list")
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

    @RequiresPermissionsDesc(menu = {"需求管理", "需求列表"}, button = "带日期查询")
    @OperationLog(menu = {"需求管理", "需求列表"}, action = "带日期查询")
    @RequiresPermissions("userOrder:dateList")
    @GetMapping(value = "/dateList")
    public CommonResult<IPage<UserOrderVo>> getDateOrderIPage(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                              @RequestParam(value = "userId", required = false) Long userId,
                                                              @RequestParam(value = "receiver", required = false) String receiver,
                                                              @RequestParam(value = "orderSn", required = false) Long orderSn,
                                                              @RequestParam(value = "dateState", defaultValue = "4", required = false) Integer dateState,
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


    @RequiresPermissionsDesc(menu = {"需求管理", "需求列表"}, button = "带日期总计查询")
    @OperationLog(menu = {"需求管理", "需求列表"}, action = "带日期总计查询")
    @RequiresPermissions("userOrder:dateListCount")
    @GetMapping(value = "/dateListCount")
    public CommonResult<IPage<UserOrderVo>> getAllDateProductIPage(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                   @RequestParam(value = "userId", required = false) Long userId,
                                                                   @RequestParam(value = "receiver", required = false) String receiver,
                                                                   @RequestParam(value = "dateState", defaultValue = "4", required = false) Integer dateState,
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

    @RequiresPermissionsDesc(menu = {"需求管理", "需求列表"}, button = "带日期不分组总计查询")
    @OperationLog(menu = {"需求管理", "需求列表"}, action = "带日期不分组总计查询")
    @RequiresPermissions("userOrder:dateListNoGroup")
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

    @RequiresPermissionsDesc(menu = {"需求管理", "需求列表"}, button = "带日期不分组全部查询")
    @OperationLog(menu = {"需求管理", "需求列表"}, action = "带日期不分组全部查询")
    @RequiresPermissions("userOrder:dateListAll")
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

    @RequiresPermissionsDesc(menu = {"需求管理", "需求列表"}, button = "带日期不分组每日全部查询")
    @OperationLog(menu = {"需求管理", "需求列表"}, action = "带日期不分组每日全部查询")
    @RequiresPermissions("userOrder:dateListAllDay")
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

    @RequiresPermissionsDesc(menu = {"需求管理", "需求列表"}, button = "带日期不分组每月全部查询")
    @OperationLog(menu = {"需求管理", "需求列表"}, action = "带日期不分组每月全部查询")
    @RequiresPermissions("userOrder:dateListAllMonth")
    @GetMapping(value = "/dateListAllMonth")
    public CommonResult<List<UserOrderVo>> getAllDateOrderAllListMonth(
            @RequestParam(value = "userId", required = false) Long userId,
            @RequestParam(value = "receiver", required = false) String receiver,
            @RequestParam(value = "dateState", defaultValue = "4", required = false) Integer dateState,
            @RequestParam(value = "specifiedTime1", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd")
                    String specifiedTime1,
            @RequestParam(value = "specifiedTime2", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd")
                    String specifiedTime2) {
        List<UserOrderVo> userOrderList = userOrderService.selectOrderListDateCountSearchAllListMonth(userId, receiver, dateState, specifiedTime1, specifiedTime2);
        return CommonResult.success(userOrderList);
    }

    @RequiresPermissionsDesc(menu = {"需求管理", "需求列表"}, button = "修改")
    @OperationLog(menu = {"需求管理", "需求列表"}, action = "修改")
    @RequiresPermissions("userOrder:update")
    @PutMapping(value = "/update")
    public CommonResult update(@RequestBody UserOrder userOrder) {
        System.out.println("userOrder" + userOrder);
        int count = userOrderService.updateByOrderSn(userOrder);
        return CommonResult.success(count);

    }
}
