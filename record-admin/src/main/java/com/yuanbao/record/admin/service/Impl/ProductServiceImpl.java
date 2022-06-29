package com.yuanbao.record.admin.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.admin.service.ProductService;
import com.yuanbao.record.mbp.mapper.ProductMapper;
import com.yuanbao.record.mbp.mapper.entity.Product;
import com.yuanbao.record.mbp.vo.ProductVo;
import com.yuanbao.record.mbp.vomapper.ProductVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public IPage<ProductVo> selectProductListSearch(Integer pageNum, Integer pageSize, IPage<Product> page, String title, Integer type) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        IPage<ProductVo> voPage = new Page<>();
        List<ProductVo> productVoList = new ArrayList<>();
        IPage<Product> productIPage = productMapper.selectProductListSearch(pageNum, pageSize, page, title, type);
        List<Product> productList = productIPage.getRecords();
        for (Product product : productList) {
            ProductVo productVo = ProductVoMapper.productvomapper.Trans(product);
            productVoList.add(productVo);
        }
        voPage.setRecords(productVoList);
        voPage.setCurrent(pageNum);
        voPage.setSize(pageSize);
        voPage.setTotal(productIPage.getTotal());
        return voPage;
    }

    @Override
    public List<ProductVo> selectProductList() {
        List<Product> productList = productMapper.selectProductListSearchAll("", null);
        System.out.println("productList:" + productList);
        List<ProductVo> productVoList = new ArrayList<>();
        for (Product product : productList) {
            ProductVo productVo = ProductVoMapper.productvomapper.Trans(product);
            productVoList.add(productVo);
        }
        return productVoList;
    }

    @Override
    public int insert(Product product) {
        return productMapper.insert(product);
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
