package com.yuanbao.record.search.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuanbao.record.search.mapper.entity.EsProductSkus;

public interface EsProductService {

    Boolean importAllInfo();

    IPage<EsProductSkus> selectProductSkusListSearchIPage(Integer pageNum, Integer pageSize, IPage<EsProductSkus> page, String title, String productName);

}
