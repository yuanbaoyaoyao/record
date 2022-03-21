package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuanbao.record.mbp.mapper.entity.UserOrder;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface UserOrderMapper extends BaseMapper<UserOrder> {
    IPage<UserOrder> selectOrderListSearch(Integer pageNum, Integer pageSize, IPage<UserOrder> page, Long userId, String productTitle, String productSkusTitle, Long orderSn, Integer orderStatus);

    IPage<UserOrder> selectOrderListDateSearch(Integer pageNum, Integer pageSize, IPage<UserOrder> page, Long userId, String receiver,Integer dateState, LocalDateTime specifiedTime1, LocalDateTime specifiedTime2);

    List<UserOrder> selectIdOrderByReceiver(String receiver);

    int insert(UserOrder userOrder);

//    int updateByPrimaryKey(UserOrder userOrder);

    int updateByOrderSn(UserOrder userOrder);
}
