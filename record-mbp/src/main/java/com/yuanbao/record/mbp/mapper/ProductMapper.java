package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuanbao.record.mbp.mapper.entity.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {
    IPage<Product> selectProductListSearch(Integer pageNum, Integer pageSize, IPage<Product> page, String keyword1);

    int insert(Product product);

    int updateByPrimaryKey(Product product);
}
