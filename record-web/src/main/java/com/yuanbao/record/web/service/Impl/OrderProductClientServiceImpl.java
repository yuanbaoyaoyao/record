package com.yuanbao.record.web.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.mbp.mapper.OrderProductMapper;
import com.yuanbao.record.mbp.mapper.entity.OrderProduct;
import com.yuanbao.record.web.service.OrderProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProductClientServiceImpl extends ServiceImpl<OrderProductMapper, OrderProduct> implements OrderProductClientService {
    @Autowired
    private OrderProductMapper orderProductMapper;

    @Override
    public int insert(OrderProduct orderProduct) {
        int id = orderProductMapper.insert(orderProduct);
        return id;
    }
}
