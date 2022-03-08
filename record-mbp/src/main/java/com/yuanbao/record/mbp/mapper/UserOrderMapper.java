package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuanbao.record.mbp.mapper.entity.UserOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserOrderMapper extends BaseMapper<UserOrder> {
    IPage<UserOrder> selectOrderListSearch(Integer pageNum, Integer pageSize, IPage<UserOrder> page, Long userId, String productTitle, String productSkusTitle,Long orderSn);

    int insert(UserOrder userOrder);
}
