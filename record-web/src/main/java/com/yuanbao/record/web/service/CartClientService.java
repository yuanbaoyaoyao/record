package com.yuanbao.record.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.Cart;
import com.yuanbao.record.mbp.vo.CartVo;

import java.util.List;

public interface CartClientService extends IService<Cart> {
    List<CartVo> selectByUserId (Long userId);

    Cart selectByUserIdAndProductSkusId(Long userId,Long productSkusId);

    int insert (Cart cart);

    int updateByUserIdAndProductSkusId(Cart cart);

    int updateAllCheckedDefaultByUserId(Cart cart);

    int deleteByPrimaryKey(long tempId);
}
