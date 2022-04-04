package com.yuanbao.record.web.controller;

import com.yuanbao.record.common.api.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.Cart;
import com.yuanbao.record.mbp.vo.CartVo;
import com.yuanbao.record.web.service.CartClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/cartClient")
public class CartClientController {
    @Autowired
    private CartClientService cartClientService;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Cart cart) {

        int newId = cartClientService.insert(cart);
        if (newId > 0) {
            return CommonResult.success(newId);
        } else {
            return CommonResult.failed();
        }
    }

    @GetMapping(value = "/list")
    public CommonResult<List<CartVo>> getList(@RequestParam(value = "userId") Long userId) {
        List<CartVo> cartVoList = cartClientService.selectByUserId(userId);
        return CommonResult.success(cartVoList);
    }

    @GetMapping(value = "/listOne")
    public CommonResult getListOne(@RequestParam(value = "userId") Long userId,
                                   @RequestParam(value = "productSkusId") Long productSkusId) {
        Cart cart = cartClientService.selectByUserIdAndProductSkusId(userId, productSkusId);
        return CommonResult.success(cart);
    }

    @PutMapping(value = "/update")
    public CommonResult update(@RequestBody Cart cart) {
        int count = cartClientService.updateByUserIdAndProductSkusId(cart);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @DeleteMapping(value = "/delete")
    public CommonResult delete(@RequestBody Cart cart) {
        long tempId = cart.getId();
        int count = cartClientService.deleteByPrimaryKey(tempId);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
