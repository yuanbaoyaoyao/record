package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuanbao.record.mbp.mapper.entity.ProductSkusDetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductSkusDetailsMapper extends BaseMapper<ProductSkusDetails> {

    List<ProductSkusDetails> selectList(Long productSkusId);

    int insert(ProductSkusDetails productSkusDetails);

    int updateByPrimaryKey(ProductSkusDetails productSkusDetails);
}
