package com.yuanbao.record.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.OrderProduct;
import com.yuanbao.record.mbp.vo.OrderProductVo;

import java.util.List;

public interface OrderProductClientService extends IService<OrderProduct> {
    List<OrderProductVo> selectOrderProductList(Long userOrderId,Long orderSn,String productTitle,String productSkusTitle);

    int insert(OrderProduct orderProduct);
}
