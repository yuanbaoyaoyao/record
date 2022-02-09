package com.yuanbao.record.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.entity.Product;
import com.yuanbao.record.mbp.vo.ProductVo;

public interface ProductService extends IService<Product> {
    IPage<ProductVo> selectProductListSearch(Integer pageNum, Integer pageSize, IPage<ProductVo> page, String keyword);

    int insert(Product product);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKey(Product product);
}
