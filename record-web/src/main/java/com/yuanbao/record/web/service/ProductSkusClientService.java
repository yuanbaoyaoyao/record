package com.yuanbao.record.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.ProductSkus;
import com.yuanbao.record.mbp.vo.ProductSkusVo;

import java.util.List;

public interface ProductSkusClientService extends IService<ProductSkus> {
    IPage<ProductSkusVo> selectProductSkusListSearchIPage(Integer pageNum, Integer pageSize, IPage<ProductSkus> page, String title,Long id);

    List<ProductSkusVo> selectProductSkusListSearch(String title,Long id,Long productId);

    List<ProductSkusVo> selectProductSkusList();

    List<ProductSkusVo> selectProductSkusListLimit();

    int updateByPrimaryKey(ProductSkus productSkus);
}
