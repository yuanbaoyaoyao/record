package com.yuanbao.record.admin.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.admin.service.OrderProductService;
import com.yuanbao.record.mbp.mapper.OrderProductMapper;
import com.yuanbao.record.mbp.mapper.entity.OrderProduct;
import com.yuanbao.record.mbp.vo.OrderProductVo;
import com.yuanbao.record.mbp.vomapper.OrderProductVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderProductServiceImpl extends ServiceImpl<OrderProductMapper, OrderProduct> implements OrderProductService {
    @Autowired
    private OrderProductMapper orderProductMapper;

    @Override
    public List<OrderProductVo> selectOrderProductList(Long userOrderId, Long orderSn, String productTitle, String productSkusTitle) {
        List<OrderProduct> orderProductList = orderProductMapper.selectOrderProductList(userOrderId, orderSn, productTitle, productSkusTitle);
        List<OrderProductVo> orderProductVoList = new ArrayList<>();
        for (OrderProduct orderProduct : orderProductList) {
            OrderProductVo orderProductVo = OrderProductVoMapper.orderproductvomapper.Trans(orderProduct);
            orderProductVoList.add(orderProductVo);
        }
        return orderProductVoList;
    }

    @Override
    public IPage<OrderProductVo> selectOrderProductListDateSearchStatus(Integer pageNum, Integer pageSize, IPage<OrderProduct> page, Long userOrderId, Long orderSn,String receiver ,String productTitle, String productSkusTitle, Integer dateState, String specifiedTime1, String specifiedTime2) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        IPage<OrderProductVo> voPage = new Page<>();
        List<OrderProductVo> orderProductVoList = new ArrayList<>();
        IPage<OrderProduct> orderProductIPage = orderProductMapper.selectOrderProductListDateSearchStatus(pageNum, pageSize, page, userOrderId, orderSn,receiver, productTitle, productSkusTitle, dateState, specifiedTime1, specifiedTime2);
        List<OrderProduct> orderProductList = orderProductIPage.getRecords();
        for (OrderProduct orderProduct : orderProductList) {
            OrderProductVo orderProductVo = OrderProductVoMapper.orderproductvomapper.Trans(orderProduct);
            orderProductVoList.add(orderProductVo);
        }
        voPage.setRecords(orderProductVoList);
        voPage.setCurrent(pageNum);
        voPage.setSize(pageSize);
        voPage.setTotal(orderProductIPage.getTotal());
        return voPage;
    }

    @Override
    public int insert(OrderProduct orderProduct) {
        int id = orderProductMapper.insert(orderProduct);
        return id;
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return orderProductMapper.deleteById(id);
    }

//    @Override
//    public int updateByOrderSn(OrderProduct orderProduct) {
//        return 0;
//    }
}
