package com.yuanbao.record.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.UserOrder;
import com.yuanbao.record.mbp.vo.UserOrderVo;

public interface UserOrderClientService extends IService<UserOrder> {
    IPage<UserOrderVo> selectOrderListSearch(Integer pageNum, Integer pageSize, IPage<UserOrder> page, Long userId, String productTitle, String productSkusTitle,Long orderSn,Long id,Integer orderStatus);

    int insert(UserOrder userOrder);

//    int updateByPrimaryKey(UserOrder userOrder);

    int updateByOrderSn(UserOrder userOrder);

    int deleteByPrimaryKey(Long id);
}
