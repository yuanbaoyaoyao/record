package com.yuanbao.record.web.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.common.util.IdGenerator;
import com.yuanbao.record.mbp.mapper.UserOrderMapper;
import com.yuanbao.record.mbp.mapper.entity.UserOrder;
import com.yuanbao.record.mbp.vo.UserOrderVo;
import com.yuanbao.record.mbp.vomapper.UserOrderVoMapper;
import com.yuanbao.record.web.service.UserOrderClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserOrderClientServiceImpl extends ServiceImpl<UserOrderMapper, UserOrder> implements UserOrderClientService {
    @Autowired
    private UserOrderMapper userOrderMapper;

    @Override
    public IPage<UserOrderVo> selectOrderListSearch(Integer pageNum, Integer pageSize, IPage<UserOrder> page, Long userId, String productTitle, String productSkusTitle, Long orderSn,Integer orderStatus) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        IPage<UserOrderVo> voPage = new Page<>();
        List<UserOrderVo> userOrderVoList = new ArrayList<>();
        IPage<UserOrder> userOrderIPage = userOrderMapper.selectOrderListSearch(pageNum, pageSize, page, userId, productTitle, productSkusTitle, orderSn,orderStatus);
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

    @Override
    public int insert(UserOrder userOrder) {
        IdGenerator idGenerator = new IdGenerator(0, 0);
        Long uuid = idGenerator.nextId();
        userOrder.setOrderSn(uuid);
        //1：审核中
        userOrder.setOrderStatus(1);
        System.out.println("insert userOrder" + userOrder);
        return userOrderMapper.insert(userOrder);
    }

    @Override
    public int updateByOrderSn(UserOrder userOrder) {
        return userOrderMapper.updateByOrderSn(userOrder);
    }

//    @Override
//    public int updateByPrimaryKey(UserOrder userOrder) {
//        return 0;
//    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userOrderMapper.deleteById(id);
    }
}
