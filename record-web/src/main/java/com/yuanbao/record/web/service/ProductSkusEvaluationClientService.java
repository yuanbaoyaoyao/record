package com.yuanbao.record.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.ProductSkusEvaluation;
import com.yuanbao.record.mbp.vo.ProductSkusEvaluationVo;

import java.util.List;

public interface ProductSkusEvaluationClientService extends IService<ProductSkusEvaluation> {
    IPage<ProductSkusEvaluationVo> selectProductSkusEvaluationListSearchIPage(Integer pageNum, Integer pageSize, IPage<ProductSkusEvaluation> page, Long orderSn, Long orderProductId, Long productSkusId);

    List<ProductSkusEvaluationVo> selectProductSkusEvaluationListSearch(Long orderSn, Long orderProductId, Long productSkusId);

    int insert(ProductSkusEvaluation productSkusEvaluation);

    int updateByPrimaryKey(ProductSkusEvaluation productSkusEvaluation);

    int deleteByPrimaryKey(Long id);
}
