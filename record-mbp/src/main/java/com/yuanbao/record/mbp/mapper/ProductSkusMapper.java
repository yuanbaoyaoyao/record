package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuanbao.record.mbp.entity.ProductSkus;
import com.yuanbao.record.mbp.vo.ProductSkusVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductSkusMapper extends BaseMapper<ProductSkus> {
    IPage<ProductSkusVo> selectProductSkusListSearch(Integer pageNum, Integer pageSize, IPage<ProductSkusVo> page, String keyword);

    int insert(ProductSkus productSkus);

    int updateByPrimaryKey(ProductSkus productSkus);
}
