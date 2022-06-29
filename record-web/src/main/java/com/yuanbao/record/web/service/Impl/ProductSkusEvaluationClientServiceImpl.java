package com.yuanbao.record.web.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.mbp.mapper.ProductSkusEvaluationMapper;
import com.yuanbao.record.mbp.mapper.entity.ProductSkusEvaluation;
import com.yuanbao.record.mbp.vo.ProductSkusEvaluationVo;
import com.yuanbao.record.mbp.vomapper.ProductSkusEvaluationVoMapper;
import com.yuanbao.record.web.service.ProductSkusEvaluationClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductSkusEvaluationClientServiceImpl extends ServiceImpl<ProductSkusEvaluationMapper, ProductSkusEvaluation> implements ProductSkusEvaluationClientService {

    @Autowired
    private ProductSkusEvaluationMapper productSkusEvaluationMapper;

    @Override
    public IPage<ProductSkusEvaluationVo> selectProductSkusEvaluationListSearchIPage(Integer pageNum, Integer pageSize, IPage<ProductSkusEvaluation> page, Long orderSn, Long orderProductId, Long productSkusId) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        IPage<ProductSkusEvaluationVo> voPage = new Page<>();
        List<ProductSkusEvaluationVo> productSkusEvaluationVoList = new ArrayList<>();
        IPage<ProductSkusEvaluation> productSkusEvaluationIPage = productSkusEvaluationMapper.selectProductSkusEvaluationListSearchIPage(pageNum, pageSize, page, orderSn, orderProductId, productSkusId);
        List<ProductSkusEvaluation> productSkusEvaluationList = productSkusEvaluationIPage.getRecords();
        for (ProductSkusEvaluation productSkusEvaluation : productSkusEvaluationList) {
            ProductSkusEvaluationVo productSkusEvaluationVo = ProductSkusEvaluationVoMapper.productskusevaluationvomapper.Trans(productSkusEvaluation);
            productSkusEvaluationVoList.add(productSkusEvaluationVo);
        }
        voPage.setRecords(productSkusEvaluationVoList);
        voPage.setCurrent(pageNum);
        voPage.setSize(pageSize);
        voPage.setTotal(productSkusEvaluationIPage.getTotal());
        return voPage;
    }

    @Override
    public List<ProductSkusEvaluationVo> selectProductSkusEvaluationListSearch(Long orderSn, Long orderProductId, Long productSkusId) {
        List<ProductSkusEvaluationVo> productSkusEvaluationVoList = new ArrayList<>();
        List<ProductSkusEvaluation> productSkusEvaluationList = productSkusEvaluationMapper.selectProductSkusEvaluationListSearch(orderSn, orderProductId, productSkusId);
        for (ProductSkusEvaluation productSkusEvaluation : productSkusEvaluationList) {
            ProductSkusEvaluationVo productSkusEvaluationVo = ProductSkusEvaluationVoMapper.productskusevaluationvomapper.Trans(productSkusEvaluation);
            productSkusEvaluationVoList.add(productSkusEvaluationVo);
        }

        return productSkusEvaluationVoList;
    }

    @Override
    public int insert(ProductSkusEvaluation ProductSkusEvaluation) {
        return productSkusEvaluationMapper.insert(ProductSkusEvaluation);
    }

    @Override
    public int updateByPrimaryKey(ProductSkusEvaluation productSkusEvaluation) {
        return productSkusEvaluationMapper.updateByPrimaryKey(productSkusEvaluation);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return productSkusEvaluationMapper.deleteById(id);
    }
}
