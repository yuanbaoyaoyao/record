package com.yuanbao.record.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.mbp.mapper.entity.ProductSkusEvaluation;
import com.yuanbao.record.mbp.vo.ProductSkusEvaluationVo;
import com.yuanbao.record.web.service.ProductSkusEvaluationClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/productSkusEvaluationClient")
public class ProductSkusEvaluationClientController {

    @Autowired
    private ProductSkusEvaluationClientService productSkusEvaluationClientService;

    @GetMapping(value = "/listIPage")
    public CommonResult<IPage<ProductSkusEvaluationVo>> getListIPage(
            @RequestParam(value = "pageSize", defaultValue = "7") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "orderSn", required = false) Long orderSn,
            @RequestParam(value = "orderProductId", required = false) Long orderProductId,
            @RequestParam(value = "productSkusId", required = false) Long productSkusId) {
        IPage<ProductSkusEvaluation> page = new Page<>();
        IPage<ProductSkusEvaluationVo> productSkusEvaluationVoIPage = productSkusEvaluationClientService.selectProductSkusEvaluationListSearchIPage(pageNum, pageSize, page, orderSn, orderProductId, productSkusId);
        System.out.println(productSkusEvaluationVoIPage.getRecords());
        return CommonResult.success(productSkusEvaluationVoIPage);
    }

    @GetMapping(value = "/list")
    public CommonResult<List<ProductSkusEvaluationVo>> getList(
            @RequestParam(value = "orderSn", required = false) Long orderSn,
            @RequestParam(value = "orderProductId", required = false) Long orderProductId,
            @RequestParam(value = "productSkusId", required = false) Long productSkusId) {
        List<ProductSkusEvaluationVo> productSkusEvaluationVoList = productSkusEvaluationClientService.selectProductSkusEvaluationListSearch(orderSn, orderProductId, productSkusId);
        return CommonResult.success(productSkusEvaluationVoList);
    }

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody ProductSkusEvaluation productSkusEvaluation) {
        int newId = productSkusEvaluationClientService.insert(productSkusEvaluation);
        if (newId > 0) {
            return CommonResult.success(newId);
        } else {
            return CommonResult.failed();
        }
    }

    @PutMapping(value = "/update")
    public CommonResult update(@RequestBody ProductSkusEvaluation productSkusEvaluation) {
        int count = productSkusEvaluationClientService.updateByPrimaryKey(productSkusEvaluation);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @DeleteMapping(value = "/delete")
    public CommonResult delete(@RequestBody ProductSkusEvaluation productSkusEvaluation) {
        long tempId = productSkusEvaluation.getId();
        int count = productSkusEvaluationClientService.deleteByPrimaryKey(tempId);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
