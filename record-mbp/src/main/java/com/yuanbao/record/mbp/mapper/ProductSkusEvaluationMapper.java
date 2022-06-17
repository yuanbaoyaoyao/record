package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuanbao.record.mbp.mapper.entity.ProductSkusEvaluation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductSkusEvaluationMapper extends BaseMapper<ProductSkusEvaluation> {

    IPage<ProductSkusEvaluation> selectProductSkusEvaluationListSearchIPage(Integer pageNum, Integer pageSize, IPage<ProductSkusEvaluation> page, Long orderSn, Long orderProductId, Long productSkusId);

    List<ProductSkusEvaluation> selectProductSkusEvaluationListSearch(Long orderSn, Long orderProductId, Long productSkusId);

    int insert(ProductSkusEvaluation ProductSkusEvaluation);

}
