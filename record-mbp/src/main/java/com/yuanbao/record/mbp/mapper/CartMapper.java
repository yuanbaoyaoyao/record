package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuanbao.record.mbp.mapper.entity.Cart;
import com.yuanbao.record.mbp.vo.CartVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper extends BaseMapper<Cart> {
     List<CartVo> selectByUserId (Long userId);

     Cart selectByUserIdAndProductSkusId(Long userId,Long productSkusId);

     int insert (Cart cart);

     int updateByUserIdAndProductSkusId(Cart cart);

     int updateAllCheckedDefaultByUserId(Cart cart);
}
