package com.yuanbao.record.web.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.mbp.mapper.CartMapper;
import com.yuanbao.record.mbp.mapper.entity.Cart;
import com.yuanbao.record.mbp.vo.CartVo;
import com.yuanbao.record.web.service.CartClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartClientServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartClientService {
    @Autowired
    private CartMapper cartMapper;

    @Override
    public List<CartVo> selectByUserId(Long userId) {
        return cartMapper.selectByUserId(userId);
    }

    @Override
    public Cart selectByUserIdAndProductSkusId(Long userId, Long productSkusId) {
         return  cartMapper.selectByUserIdAndProductSkusId(userId,productSkusId);
    }

    @Override
    public int insert(Cart cart) {
        int id = cartMapper.insert(cart);
        return id;
    }

    @Override
    public int updateByUserIdAndProductSkusId(Cart cart) {
        return cartMapper.updateByUserIdAndProductSkusId(cart);
    }

    @Override
    public int deleteByPrimaryKey(long tempId) {
        return cartMapper.deleteById(tempId);
    }
}
