//package com.yuanbao.record.admin.service.Impl;
//
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.yuanbao.record.admin.service.OrderProductService;
//import com.yuanbao.record.mbp.mapper.OrderProductMapper;
//import com.yuanbao.record.mbp.mapper.entity.OrderProduct;
//import com.yuanbao.record.mbp.vo.OrderProductVo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class OrderProductServiceImpl extends ServiceImpl<OrderProductMapper, OrderProduct> implements OrderProductService {
//    @Autowired
//    private OrderProductMapper orderProductMapper;
//
//    @Override
//    public List<OrderProductVo> selectOrderProductList(Long userOrderId,String productTitle,String productSkusTitle) {
//        return orderProductMapper.selectOrderProductList(userOrderId,productTitle,productSkusTitle);
//    }
//
//    @Override
//    public int insert(OrderProduct orderProduct) {
//        int id = orderProductMapper.insert(orderProduct);
//        return id;
//    }
//
//    @Override
//    public int deleteByPrimaryKey(Long id) {
//        return orderProductMapper.deleteById(id);
//    }
//
////    @Override
////    public int updateByOrderSn(OrderProduct orderProduct) {
////        return 0;
////    }
//}
