package com.yuanbao.record.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.UserCollect;
import com.yuanbao.record.mbp.vo.UserCollectVo;
import com.yuanbao.record.web.service.UserCollectClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/userCollectClient")
public class UserCollectClientController {
    @Autowired
    private UserCollectClientService userCollectClientService;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody UserCollect userCollect) {

        int newId = userCollectClientService.insert(userCollect);
        if (newId > 0) {
            return CommonResult.success(newId);
        } else {
            return CommonResult.failed();
        }
    }

    @GetMapping(value = "/list")
    public CommonResult<IPage<UserCollectVo>> getAllOrder(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                          @RequestParam(value = "userId") Long userId) {
        IPage<UserCollect> page = new Page<>();
        IPage<UserCollectVo> userCollectVoIPage = userCollectClientService.selectProductSkusByUserId(pageNum, pageSize, page, userId);
        return CommonResult.success(userCollectVoIPage);
    }

    @GetMapping(value = "/IsLike")
    public CommonResult<List<UserCollectVo>> getAllOrder(@RequestParam(value = "productSkusId") Long productSkusId,
                                                          @RequestParam(value = "userId") Long userId) {
        List<UserCollectVo> userCollectVoList = userCollectClientService.selectIDByUserIdAndProuductSkusId(userId,productSkusId);
        return CommonResult.success(userCollectVoList);
    }

    @DeleteMapping(value = "/delete")
    public CommonResult delete(@RequestBody UserCollect userCollect) {
        long tempId = userCollect.getId();
        int count = userCollectClientService.deleteByPrimaryKey(tempId);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
