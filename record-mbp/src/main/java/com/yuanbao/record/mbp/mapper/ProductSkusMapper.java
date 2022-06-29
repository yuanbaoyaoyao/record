package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuanbao.record.mbp.mapper.entity.ProductSkus;
import com.yuanbao.record.mbp.vo.ProductSkusVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductSkusMapper extends BaseMapper<ProductSkus> {
    IPage<ProductSkus> selectProductSkusListSearchIPage(Integer pageNum, Integer pageSize, IPage<ProductSkus> page, String productName, Long id, String productSkusName);

    IPage<ProductSkus> selectProductSkusListByProductTypeIPage(Integer pageNum, Integer pageSize, IPage<ProductSkus> page, Integer type);

    IPage<ProductSkus> selectProductSkusListCountByProductIdAndTypeIPage(Integer pageNum, Integer pageSize, IPage<ProductSkus> page, Long productId, Integer type, Long userId);

    List<ProductSkusVo> selectProductSkusListSearch(String title, Long id, Long productId, String productSkusName);

    List<ProductSkusVo> selectProductSkusList();

    List<ProductSkusVo> selectProductSkusListLimit();

    List<ProductSkus> selectProductSkusListLimitNumber(Integer number);

    int insert(ProductSkus productSkus);

    int updateByPrimaryKey(ProductSkus productSkus);
}
