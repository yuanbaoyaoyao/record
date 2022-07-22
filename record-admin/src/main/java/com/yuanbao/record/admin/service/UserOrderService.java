package com.yuanbao.record.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.UserOrder;
import com.yuanbao.record.mbp.vo.UserOrderVo;

import java.util.List;

public interface UserOrderService extends IService<UserOrder> {
    IPage<UserOrderVo> selectOrderListSearch(Integer pageNum, Integer pageSize, IPage<UserOrder> page, Long userId, String productTitle, String productSkusTitle, Long orderSn,Long id, Integer orderStatus);

    IPage<UserOrderVo> selectOrderListDateSearch(Integer pageNum, Integer pageSize, IPage<UserOrder> page, Long userId, Integer dateState, String receiver,Long orderSn, String specifiedTime1, String specifiedTime2);

    IPage<UserOrderVo> selectOrderListDateCountSearch(Integer pageNum, Integer pageSize, IPage<UserOrder> page, Long userId, Integer dateState, String receiver, String specifiedTime1, String specifiedTime2);

    IPage<UserOrderVo> selectOrderListDateCountSearchNoGroup(Integer pageNum, Integer pageSize, IPage<UserOrder> page, Long userId, String receiver, Integer dateState, String specifiedTime1, String specifiedTime2);

    List<UserOrderVo> selectOrderListDateCountSearchAllList(Long userId, String receiver, Integer dateState, String specifiedTime1, String specifiedTime2);

    List<UserOrderVo> selectOrderListDateCountSearchAllListDay(Long userId, String receiver, Integer dateState, String specifiedTime1, String specifiedTime2);

    List<UserOrderVo> selectOrderListDateCountSearchAllListMonth(Long userId, String receiver, Integer dateState, String specifiedTime1, String specifiedTime2);

    //    int updateByPrimaryKey(UserOrder userOrder);

    int updateByOrderSn(UserOrder userOrder);

}
