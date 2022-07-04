package com.yuanbao.record.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.ProductSkusDetails;
import com.yuanbao.record.mbp.vo.ProductSkusDetailsVo;

import java.util.List;

public interface ProductSkusDetailsService extends IService<ProductSkusDetails> {

    List<ProductSkusDetailsVo> selectList(Long productSkusId);

    int insert(ProductSkusDetails productSkusDetails);

    int updateByPrimaryKey(ProductSkusDetails productSkusDetails);

    int deleteByPrimaryKey(Long id);
}
