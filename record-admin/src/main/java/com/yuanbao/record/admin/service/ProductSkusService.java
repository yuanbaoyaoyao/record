package com.yuanbao.record.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.ProductSkus;
import com.yuanbao.record.mbp.vo.ProductSkusVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductSkusService extends IService<ProductSkus> {
    IPage<ProductSkusVo> selectProductSkusListSearch(Integer pageNum, Integer pageSize, IPage<ProductSkusVo> page, String keyword);

    List<ProductSkusVo> selectProductSkusList();

    @Transactional
    int insert(ProductSkus productSkus);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKey(ProductSkus productSkus);
}
