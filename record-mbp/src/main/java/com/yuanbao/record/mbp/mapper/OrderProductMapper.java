package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuanbao.record.mbp.mapper.entity.OrderProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderProductMapper extends BaseMapper<OrderProduct> {
    List<OrderProduct> selectOrderProductList(Long userOrderId,String productTitle,String productSkusTitle);

    int insert(OrderProduct orderProduct);

    int updateByOrderSn(OrderProduct orderProduct);
}
