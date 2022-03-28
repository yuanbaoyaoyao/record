package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuanbao.record.mbp.mapper.entity.OrderProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderProductMapper extends BaseMapper<OrderProduct> {
    List<OrderProduct> selectOrderProductList(Long userOrderId,Long orderSn,String productTitle,String productSkusTitle);

    IPage<OrderProduct> selectOrderProductListDateSearchStatus(Integer pageNum, Integer pageSize, IPage<OrderProduct> page, Long userOrderId,Long orderSn,String receiver,String productTitle,String productSkusTitle, Integer dateState, String specifiedTime1, String specifiedTime2);

    int insert(OrderProduct orderProduct);

    int updateByOrderSn(OrderProduct orderProduct);
}
