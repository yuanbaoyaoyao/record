package com.yuanbao.record.admin.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.admin.service.ProductSkusDetailsService;
import com.yuanbao.record.mbp.mapper.ProductSkusDetailsMapper;
import com.yuanbao.record.mbp.mapper.entity.ProductSkusDetails;
import com.yuanbao.record.mbp.vo.ProductSkusDetailsVo;
import com.yuanbao.record.mbp.vomapper.ProductSkusDetailsVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductSkusDetailsServiceImpl extends ServiceImpl<ProductSkusDetailsMapper, ProductSkusDetails> implements ProductSkusDetailsService {

    @Autowired
    private ProductSkusDetailsMapper productSkusDetailsMapper;

    @Override
    public List<ProductSkusDetailsVo> selectList(Long productSkusId) {
        List<ProductSkusDetails> productSkusDetailsList = productSkusDetailsMapper.selectList(productSkusId);
        List<ProductSkusDetailsVo> productSkusDetailsVoList = new ArrayList<>();
        for (ProductSkusDetails productSkusDetails : productSkusDetailsList) {
            ProductSkusDetailsVo productSkusDetailsVo = ProductSkusDetailsVoMapper.productskusdetailvomapper.Trans(productSkusDetails);
            productSkusDetailsVoList.add(productSkusDetailsVo);
        }
        return productSkusDetailsVoList;
    }

    @Override
    public int insert(ProductSkusDetails productSkusDetails) {
        return productSkusDetailsMapper.insert(productSkusDetails);
    }

    @Override
    public int updateByPrimaryKey(ProductSkusDetails productSkusDetails) {
        return productSkusDetailsMapper.updateByPrimaryKey(productSkusDetails);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return productSkusDetailsMapper.deleteById(id);
    }
}
