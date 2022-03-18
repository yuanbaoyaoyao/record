package com.yuanbao.record.admin.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.admin.service.UserOrderService;
import com.yuanbao.record.mbp.mapper.OrderProductMapper;
import com.yuanbao.record.mbp.mapper.UserOrderMapper;
import com.yuanbao.record.mbp.mapper.entity.OrderProduct;
import com.yuanbao.record.mbp.mapper.entity.UserOrder;
import com.yuanbao.record.mbp.vo.OrderProductVo;
import com.yuanbao.record.mbp.vo.UserOrderVo;
import com.yuanbao.record.mbp.vomapper.OrderProductVoMapper;
import com.yuanbao.record.mbp.vomapper.UserOrderVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserOrderServiceImpl extends ServiceImpl<UserOrderMapper, UserOrder> implements UserOrderService {
    @Autowired
    private UserOrderMapper userOrderMapper;

    @Autowired
    private OrderProductMapper orderProductMapper;

    @Override
    public IPage<UserOrderVo> selectOrderListSearch(Integer pageNum, Integer pageSize, IPage<UserOrder> page, Long userId, String productTitle, String productSkusTitle, Long orderSn, Integer orderStatus) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        IPage<UserOrderVo> voPage = new Page<>();
//        List<Collection<UserOrderVo>> userOrderVoList1 = new ArrayList<>();
        List<UserOrderVo> userOrderVoList = new ArrayList<>();
        IPage<UserOrder> userOrderIPage = userOrderMapper.selectOrderListSearch(pageNum, pageSize, page, userId, productTitle, productSkusTitle, orderSn, orderStatus);

        return getUserOrderVoIPage(pageNum, pageSize, voPage, userOrderVoList, userOrderIPage);
    }

    @Override
    public IPage<UserOrderVo> selectOrderListDateSearch(Integer pageNum, Integer pageSize, IPage<UserOrder> page, Long userId, Integer dateState, LocalDateTime specifiedTime1, LocalDateTime specifiedTime2) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        IPage<UserOrderVo> voPage = new Page<>();
//        List<Collection<UserOrderVo>> userOrderVoList1 = new ArrayList<>();
        List<UserOrderVo> userOrderVoList = new ArrayList<>();
        IPage<UserOrder> userOrderIPage = userOrderMapper.selectOrderListDateSearch(pageNum, pageSize, page, userId, dateState, specifiedTime1, specifiedTime2);
        return getUserOrderVoIPage(pageNum, pageSize, voPage, userOrderVoList, userOrderIPage);
    }

    private IPage<UserOrderVo> getUserOrderVoIPage(Integer pageNum, Integer pageSize, IPage<UserOrderVo> voPage , List<UserOrderVo> userOrderVoList, IPage<UserOrder> userOrderIPage) {
        List<UserOrder> userOrderList = userOrderIPage.getRecords();
        System.out.println("userOrderList" + userOrderList);
        for (UserOrder userOrder : userOrderList) {
            UserOrderVo userOrderVo = UserOrderVoMapper.userordervomapper.Trans(userOrder);
            List<OrderProductVo> orderProductVoList = new ArrayList<>();

            List<OrderProduct> orderProductList = orderProductMapper.selectOrderProductList(userOrder.getId(), "", "");
            for (OrderProduct orderProduct : orderProductList) {
                OrderProductVo orderProductVo = OrderProductVoMapper.orderproductvomapper.Trans(orderProduct);
                orderProductVoList.add(orderProductVo);
            }
            userOrderVo.setOrderProductVoList(orderProductVoList);
            userOrderVoList.add(userOrderVo);
//            System.out.println("userOrderVoList1:" + userOrderVoList);
//            orderProductVoList.clear();
//            System.out.println("userOrderVoList2:" + userOrderVoList);
        }

        voPage.setRecords(userOrderVoList);
        voPage.setCurrent(pageNum);
        voPage.setSize(pageSize);
        voPage.setTotal(userOrderIPage.getTotal());
        return voPage;
    }

//    @Override
//    public int updateByPrimaryKey(UserOrder userOrder) {
//        return userOrderMapper.updateByPrimaryKey(userOrder);
//    }

    @Override
    public int updateByOrderSn(UserOrder userOrder) {
        return userOrderMapper.updateByOrderSn(userOrder);
    }
}
