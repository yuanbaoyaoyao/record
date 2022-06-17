package com.yuanbao.record.web.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.mbp.mapper.OrderProductMapper;
import com.yuanbao.record.mbp.mapper.entity.OrderProduct;
import com.yuanbao.record.mbp.vo.OrderProductVo;
import com.yuanbao.record.mbp.vomapper.OrderProductVoMapper;
import com.yuanbao.record.web.service.OrderProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderProductClientServiceImpl extends ServiceImpl<OrderProductMapper, OrderProduct> implements OrderProductClientService {
    @Autowired
    private OrderProductMapper orderProductMapper;

    @Override
    public List<OrderProductVo> selectOrderProductList(Long userOrderId, Long orderSn, String productTitle, String productSkusTitle) {
        List<OrderProductVo> orderProductVoList = new ArrayList<>();
        List<OrderProduct> orderProductList = orderProductMapper.selectOrderProductList(userOrderId, orderSn, productTitle, productSkusTitle);
        for (OrderProduct orderProduct : orderProductList) {
            OrderProductVo orderProductVo = OrderProductVoMapper.orderproductvomapper.Trans(orderProduct);
            orderProductVoList.add(orderProductVo);
        }
        return orderProductVoList;
    }

    @Override
    public int insert(OrderProduct orderProduct) {
        return orderProductMapper.insert(orderProduct);
    }
}
