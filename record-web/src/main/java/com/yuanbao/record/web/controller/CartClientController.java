package com.yuanbao.record.web.controller;

import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.Cart;
import com.yuanbao.record.mbp.mapper.entity.JwtUser;
import com.yuanbao.record.mbp.mapper.entity.User;
import com.yuanbao.record.mbp.vo.CartVo;
import com.yuanbao.record.web.service.CartClientService;
import com.yuanbao.record.web.service.UserClientService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/cartClient")
public class CartClientController {

    @Autowired
    private CartClientService cartClientService;

    @Autowired
    private UserClientService userClientService;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Cart cart) {
        JwtUser jwtUser = (JwtUser) SecurityUtils.getSubject().getPrincipal();
        User user = userClientService.selectUserListByName(jwtUser.getUsername());
        Cart cart1 = cartClientService.selectByUserIdAndProductSkusId(user.getId(), cart.getProductSkusId());
        if (cart1 != null) {
            cart.setProductSkusNumber(cart.getProductSkusNumber() + cart1.getProductSkusNumber());
            cartClientService.updateByUserIdAndProductSkusId(cart);
        } else {
            cartClientService.insert(cart);
        }
        return CommonResult.success("加入购物车成功");
    }

    @GetMapping(value = "/list")
    public CommonResult<List<CartVo>> getList(@RequestParam(value = "userId") Long userId) {
        List<CartVo> cartVoList = cartClientService.selectByUserId(userId);
        return CommonResult.success(cartVoList);
    }

    @GetMapping(value = "/listChecked")
    public CommonResult<List<CartVo>> getListChecked(@RequestParam(value = "userId") Long userId) {
        List<CartVo> cartVoList = cartClientService.selectCheckedByUserId(userId);
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
        System.out.println("cart" + cart);
        int count = cartClientService.updateByUserIdAndProductSkusId(cart);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @PutMapping(value = "/updateList")
    public CommonResult updateList(@RequestBody List<Cart> cartList) {
//        System.out.println("cartList" + cartList);
        int count = 0;
        for (Cart cart : cartList) {
            System.out.println("cart" + cart);
            count = cartClientService.updateByUserIdAndProductSkusId(cart);
        }
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @PutMapping(value = "/updateCheckedDefault")
    public CommonResult updateCheckedDefault(@RequestBody Cart cart) {
//        System.out.println("cart"+cart);
        int count = cartClientService.updateAllCheckedDefaultByUserId(cart);
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

    @DeleteMapping(value = "/deleteList")
    public CommonResult deleteList(@RequestBody List<Cart> cartList) {
        for (Cart cart : cartList) {
            long tempId = cart.getId();
            cartClientService.deleteByPrimaryKey(tempId);
        }

        return CommonResult.success("删除成功");
    }
}
