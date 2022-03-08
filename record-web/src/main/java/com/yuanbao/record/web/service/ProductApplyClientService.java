package com.yuanbao.record.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.ProductApply;
import com.yuanbao.record.mbp.vo.ProductApplyClientVo;

public interface ProductApplyClientService extends IService<ProductApply> {
    IPage<ProductApplyClientVo> selectApplyListSearch(Integer pageNum, Integer pageSize, IPage<ProductApply> page, Integer userId, String productTitle, String productSkusTitle);

    int insert(ProductApply productApply);

    int deleteByPrimaryKey(Long id);
}
