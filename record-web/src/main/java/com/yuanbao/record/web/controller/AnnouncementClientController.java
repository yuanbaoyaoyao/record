package com.yuanbao.record.web.controller;

import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.mbp.vo.AnnouncementVo;
import com.yuanbao.record.web.service.AnnouncementClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/announcementClient")
public class AnnouncementClientController {
    @Autowired
    private AnnouncementClientService announcementClientService;

    @GetMapping(value = "/list")
    public CommonResult<List<AnnouncementVo>> getList() {
        List<AnnouncementVo> announcementVoList = announcementClientService.selectAll();
        return CommonResult.success(announcementVoList);
    }
}
