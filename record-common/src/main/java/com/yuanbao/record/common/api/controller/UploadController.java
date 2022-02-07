package com.yuanbao.record.common.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.yuanbao.record.common.api.CommonResult;
import com.yuanbao.record.common.api.service.QiNiuYunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.ConnectException;

@RestController
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private QiNiuYunService qiNiuYunService;

    @GetMapping("/qiniu/policy")
    public CommonResult qiniuPolicy() {
        JSONObject json = qiNiuYunService.getQiniuPolicy();
        return CommonResult.success(json);
    }

    @PostMapping("qiniu/fetchNetSource")
    public CommonResult fetchNetSource(@RequestBody String url) throws ConnectException {
        return CommonResult.success(qiNiuYunService.fetchNetSource(url));
    }

}