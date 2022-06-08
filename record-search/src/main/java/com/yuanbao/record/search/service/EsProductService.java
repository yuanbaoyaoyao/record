package com.yuanbao.record.search.service;

import com.yuanbao.record.search.mapper.entity.EsProductSkus;
import org.springframework.data.domain.Page;

public interface EsProductService {

    Boolean importAllInfo();

    Page<EsProductSkus> selectProductSkusListSearchIPage(Integer pageNum, Integer pageSize, String title, String productName);

}
