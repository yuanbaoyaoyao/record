package com.yuanbao.record.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.ProductSkus;
import com.yuanbao.record.mbp.vo.ProductSkusVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface ProductSkusService extends IService<ProductSkus> {
    IPage<ProductSkusVo> selectProductSkusListSearchIPage(Integer pageNum, Integer pageSize, IPage<ProductSkus> page, String title,Long id);

    List<ProductSkusVo> selectProductSkusList();

    Map<String, Object> selectProductSkusChildrenLikeList();

    @Transactional
    int insert(ProductSkus productSkus);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKey(ProductSkus productSkus);
}
