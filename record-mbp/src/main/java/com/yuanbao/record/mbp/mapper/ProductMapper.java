package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuanbao.record.mbp.mapper.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {
    IPage<Product> selectProductListSearch(Integer pageNum, Integer pageSize, IPage<Product> page, String title);

    List<Product> selectProductListSearchAll(String title);

    int insert(Product product);

    int updateByPrimaryKey(Product product);
}
