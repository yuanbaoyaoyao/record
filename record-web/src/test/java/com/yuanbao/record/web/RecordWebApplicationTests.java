package com.yuanbao.record.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuanbao.record.mbp.mapper.ProductSkusEvaluationMapper;
import com.yuanbao.record.mbp.mapper.entity.ProductSkusEvaluation;
import com.yuanbao.record.web.service.ProductSkusEvaluationClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RecordWebApplicationTests {

    @Autowired
    private ProductSkusEvaluationMapper productSkusEvaluationMapper;

    @Autowired
    private ProductSkusEvaluationClientService productSkusEvaluationClientService;

    @Test
    void contextLoads() {
        IPage<ProductSkusEvaluation> page = new Page<>();
//        IPage<ProductSkusEvaluationVo> productSkusEvaluationVoIPage = productSkusEvaluationClientService.selectProductSkusEvaluationListSearchIPage(7,1)
//        IPage<ProductSkusEvaluation> productSkusEvaluationList = productSkusEvaluationMapper.selectProductSkusEvaluationListSearchIPage(7, 1, page, null, null, null);
//        System.out.println("productSkusEvaluationList:" + productSkusEvaluationList.getRecords());
//        List<ProductSkusEvaluation> productSkusEvaluationList = productSkusEvaluationMapper.selectProductSkusEvaluationListSearch(null,null,null);
//        System.out.println("productSkusEvaluationList:" + productSkusEvaluationList);

    }

}
