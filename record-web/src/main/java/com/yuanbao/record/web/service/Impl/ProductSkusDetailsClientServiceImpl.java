package com.yuanbao.record.web.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.mbp.mapper.ProductSkusDetailsMapper;
import com.yuanbao.record.mbp.mapper.entity.ProductSkusDetails;
import com.yuanbao.record.mbp.vo.ProductSkusDetailsVo;
import com.yuanbao.record.mbp.vomapper.ProductSkusDetailsVoMapper;
import com.yuanbao.record.web.service.ProductSkusDetailsClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductSkusDetailsClientServiceImpl extends ServiceImpl<ProductSkusDetailsMapper, ProductSkusDetails> implements ProductSkusDetailsClientService {

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
}
