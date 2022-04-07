package com.yuanbao.record.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.OrderProduct;

public interface OrderProductClientService extends IService<OrderProduct> {
    int insert(OrderProduct orderProduct);
}
