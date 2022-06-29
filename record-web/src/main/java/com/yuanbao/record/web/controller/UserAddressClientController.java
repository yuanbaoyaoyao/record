package com.yuanbao.record.web.controller;

import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.mbp.mapper.UserAddressMapper;
import com.yuanbao.record.mbp.mapper.entity.UserAddress;
import com.yuanbao.record.web.service.UserAddressClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/client/userAddress")
public class UserAddressClientController {

    @Autowired
    private UserAddressClientService userAddressClientService;

    @Autowired
    private UserAddressMapper userAddressMapper;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody UserAddress userAddress) {
        List<UserAddress> userAddressList = userAddressClientService.selectByUserId(userAddress.getUserId());
        int count = 0;
        for (UserAddress ignored : userAddressList) {
            count++;
        }
        if (count == 5) {
            return CommonResult.failed();
        }
        if (userAddress.getIsDefault()) {
            userAddressMapper.updateIsDefault(userAddress.getUserId());
        }
        int newId = userAddressClientService.insert(userAddress);
        if (newId > 0) {
            return CommonResult.success(newId);
        } else {
            return CommonResult.failed();
        }
    }

    @GetMapping(value = "/list")
    public CommonResult<List<UserAddress>> getAllAddress(@RequestParam(value = "userId") Long userId) {
        List<UserAddress> userAddressList = userAddressClientService.selectByUserId(userId);
        return CommonResult.success(userAddressList);
    }

    @GetMapping(value = "/listOne")
    public CommonResult getAddress(@RequestParam(value = "id") Long id) {
        UserAddress userAddress = userAddressClientService.selectById(id);
        return CommonResult.success(userAddress);
    }

    @PutMapping(value = "/update")
    public CommonResult update(@RequestBody UserAddress userAddress) {
        int count = userAddressClientService.updateByPrimaryKey(userAddress);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @DeleteMapping(value = "/delete")
    public CommonResult delete(@RequestBody UserAddress userAddress) {
        long tempId = userAddress.getId();
        int count = userAddressClientService.deleteByPrimaryKey(tempId);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
