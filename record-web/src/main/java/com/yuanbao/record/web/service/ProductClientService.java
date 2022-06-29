package com.yuanbao.record.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.Product;
import com.yuanbao.record.mbp.vo.ProductVo;

import java.util.List;

public interface ProductClientService extends IService<Product> {
    IPage<ProductVo> selectProductListSearch(Integer pageNum, Integer pageSize, IPage<Product> page, String keyword1, Integer type);

    List<ProductVo> selectProductListSearchAll(String title, Integer type);
}
