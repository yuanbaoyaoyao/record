package com.yuanbao.record.admin.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.admin.service.ProductService;
import com.yuanbao.record.mbp.mapper.entity.Product;
import com.yuanbao.record.mbp.mapper.ProductMapper;
import com.yuanbao.record.mbp.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public IPage<ProductVo> selectProductListSearch(Integer pageNum, Integer pageSize, IPage<ProductVo> page, String keyword) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        return productMapper.selectProductListSearch(pageNum, pageSize, page, keyword);
    }

    @Override
    public int insert(Product product) {
        int id = productMapper.insert(product);
        return id;
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return productMapper.deleteById(id);
    }

    @Override
    public int updateByPrimaryKey(Product product) {
        return productMapper.updateByPrimaryKey(product);
    }
}
