package com.yuanbao.record.web.controller;

import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.mbp.vo.FrontShowVo;
import com.yuanbao.record.web.service.FrontShowClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/frontShowClient")
public class FrontShowClientController {

    @Autowired
    private FrontShowClientService frontShowClientService;

    @GetMapping(value = "/listRotation")
    public CommonResult<List<FrontShowVo>> getRotation() {
        List<FrontShowVo> frontShowVoList = frontShowClientService.selectByShowRotation();
        return CommonResult.success(frontShowVoList);
    }

    @GetMapping(value = "/listOld")
    public CommonResult<List<FrontShowVo>> getOld() {
        List<FrontShowVo> frontShowVoList = frontShowClientService.selectByShowOld();
        return CommonResult.success(frontShowVoList);
    }

    @GetMapping(value = "/listNew")
    public CommonResult<List<FrontShowVo>> getNew() {
        List<FrontShowVo> frontShowVoList = frontShowClientService.selectByShowNew();
        return CommonResult.success(frontShowVoList);
    }

}
