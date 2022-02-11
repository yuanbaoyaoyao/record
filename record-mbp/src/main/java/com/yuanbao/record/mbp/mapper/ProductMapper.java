package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuanbao.record.mbp.mapper.entity.Product;
import com.yuanbao.record.mbp.vo.ProductVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {
    IPage<ProductVo> selectProductListSearch(Integer pageNum, Integer pageSize, IPage<ProductVo> page, String keyword);

    int insert(Product product);

    int updateByPrimaryKey(Product product);
}
