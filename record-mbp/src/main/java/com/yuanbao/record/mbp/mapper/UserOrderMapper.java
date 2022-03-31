package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuanbao.record.mbp.mapper.entity.UserOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserOrderMapper extends BaseMapper<UserOrder> {
    IPage<UserOrder> selectOrderListSearch(Integer pageNum, Integer pageSize, IPage<UserOrder> page, Long userId, String productTitle, String productSkusTitle, Long orderSn, Integer orderStatus);

    IPage<UserOrder> selectOrderListDateSearch(Integer pageNum, Integer pageSize, IPage<UserOrder> page, Long userId, String receiver, Long orderSn, Integer dateState, String specifiedTime1, String specifiedTime2);

    IPage<UserOrder> selectOrderListDateCountSearch(Integer pageNum, Integer pageSize, IPage<UserOrder> page, Long userId, String receiver, Integer dateState, String specifiedTime1, String specifiedTime2);

    IPage<UserOrder> selectOrderListDateCountSearchNoGroup(Integer pageNum, Integer pageSize, IPage<UserOrder> page, Long userId, String receiver, Integer dateState, String specifiedTime1, String specifiedTime2);

    List<UserOrder> selectOrderListDateCountSearchAllList(Long userId, String receiver, Integer dateState, String specifiedTime1, String specifiedTime2);

    List<UserOrder> selectOrderListDateCountSearchAllListDay(Long userId, String receiver, Integer dateState, String specifiedTime1, String specifiedTime2);

    List<UserOrder> selectOrderListDateCountSearchAllListMonth(Long userId, String receiver, Integer dateState, String specifiedTime1, String specifiedTime2);

    List<UserOrder> selectIdOrderByReceiver(String receiver);

    int insert(UserOrder userOrder);

//    int updateByPrimaryKey(UserOrder userOrder);

    int updateByOrderSn(UserOrder userOrder);
}
