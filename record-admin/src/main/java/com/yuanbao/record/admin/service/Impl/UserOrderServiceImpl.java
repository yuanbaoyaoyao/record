package com.yuanbao.record.admin.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.admin.service.UserOrderService;
import com.yuanbao.record.mbp.mapper.UserOrderMapper;
import com.yuanbao.record.mbp.mapper.entity.UserOrder;
import com.yuanbao.record.mbp.vo.UserOrderVo;
import com.yuanbao.record.mbp.vomapper.UserOrderVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserOrderServiceImpl extends ServiceImpl<UserOrderMapper, UserOrder> implements UserOrderService {
    @Autowired
    private UserOrderMapper userOrderMapper;

    @Override
    public IPage<UserOrderVo> selectOrderListSearch(Integer pageNum, Integer pageSize, IPage<UserOrder> page, Long userId, String productTitle, String productSkusTitle, Long orderSn, Integer orderStatus) {
        System.out.println("serviceImpl:userId:" + userId);
        System.out.println("serviceImpl:productTitle:" + productTitle);
        System.out.println("serviceImpl:productSkusTitle:" + productSkusTitle);
        System.out.println("serviceImpl:orderSn:" + orderSn);
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        IPage<UserOrderVo> voPage = new Page<>();
        List<UserOrderVo> userOrderVoList = new ArrayList<>();
        IPage<UserOrder> userOrderIPage = userOrderMapper.selectOrderListSearch(pageNum, pageSize, page, userId, productTitle, productSkusTitle, orderSn, orderStatus);
        List<UserOrder> userOrderList = userOrderIPage.getRecords();
        for (UserOrder userOrder : userOrderList) {
            UserOrderVo userOrderVo = UserOrderVoMapper.userordervomapper.Trans(userOrder);
            userOrderVoList.add(userOrderVo);
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
