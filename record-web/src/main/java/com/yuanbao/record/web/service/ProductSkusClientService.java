package com.yuanbao.record.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.ProductSkus;
import com.yuanbao.record.mbp.vo.ProductSkusVo;

import java.util.List;

public interface ProductSkusClientService extends IService<ProductSkus> {
    IPage<ProductSkusVo> selectProductSkusListSearchIPage(Integer pageNum, Integer pageSize, IPage<ProductSkus> page, String productName, Long id, String productSkusName);

    IPage<ProductSkusVo> selectProductSkusListByProductTypeIPage(Integer pageNum, Integer pageSize, IPage<ProductSkus> page, Integer type);

    List<ProductSkusVo> selectProductSkusListSearch(String title, Long id, Long productId, String productSkusName);

    IPage<ProductSkusVo> selectProductSkusListCountByProductIdAndTypeIPage(Integer pageNum, Integer pageSize, IPage<ProductSkus> page, Long productId,Integer type,Long userId);

    List<ProductSkusVo> selectProductSkusList();

    List<ProductSkusVo> selectProductSkusListLimit();

    List<ProductSkusVo> selectProductSkusListLimitNumber(Integer number);

    int updateByPrimaryKey(ProductSkus productSkus);
}
