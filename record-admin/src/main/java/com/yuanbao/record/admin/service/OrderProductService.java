package com.yuanbao.record.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.OrderProduct;
import com.yuanbao.record.mbp.vo.OrderProductVo;

import java.util.List;

public interface OrderProductService extends IService<OrderProduct> {
    List<OrderProductVo> selectOrderProductList(Long userOrderId, Long orderSn, String productTitle, String productSkusTitle);

    IPage<OrderProductVo> selectOrderProductListDateSearchStatus(Integer pageNum, Integer pageSize, IPage<OrderProduct> page, Long userOrderId, Long orderSn,String receiver ,String productTitle, String productSkusTitle, Integer dateState, String specifiedTime1, String specifiedTime2);

    int insert(OrderProduct orderProduct);

    int deleteByPrimaryKey(Long id);

//    int updateByOrderSn(OrderProduct orderProduct);
}
