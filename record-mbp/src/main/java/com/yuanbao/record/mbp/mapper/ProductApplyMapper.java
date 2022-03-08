package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuanbao.record.mbp.mapper.entity.ProductApply;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductApplyMapper extends BaseMapper<ProductApply> {
    IPage<ProductApply> selectApplyListSearch(Integer pageNum, Integer pageSize, IPage<ProductApply> page, Integer userId, String productTitle, String productSkusTitle);

    int insert(ProductApply productApply);
}
