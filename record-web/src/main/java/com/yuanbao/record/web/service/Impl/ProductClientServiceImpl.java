package com.yuanbao.record.web.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.mbp.mapper.ProductMapper;
import com.yuanbao.record.mbp.mapper.entity.Product;
import com.yuanbao.record.mbp.vo.ProductVo;
import com.yuanbao.record.mbp.vomapper.ProductVoMapper;
import com.yuanbao.record.web.service.ProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductClientServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductClientService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public IPage<ProductVo> selectProductListSearch(Integer pageNum, Integer pageSize, IPage<Product> page, String keyword1, Integer type) {
        return null;
    }

    @Override
    public List<ProductVo> selectProductListSearchAll(String title, Integer type) {
        List<ProductVo> productVoList = new ArrayList<>();
        List<Product> productList = productMapper.selectProductListSearchAll(title, type);
        for (Product product : productList) {
            ProductVo productVo = ProductVoMapper.productvomapper.Trans(product);
            productVoList.add(productVo);
        }
        return productVoList;
    }
}
