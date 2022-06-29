package com.yuanbao.record.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.Product;
import com.yuanbao.record.mbp.vo.ProductVo;

import java.util.List;

public interface ProductService extends IService<Product> {
    IPage<ProductVo> selectProductListSearch(Integer pageNum, Integer pageSize, IPage<Product> page, String title, Integer type);

    List<ProductVo> selectProductList();

    int insert(Product product);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKey(Product product);
}
