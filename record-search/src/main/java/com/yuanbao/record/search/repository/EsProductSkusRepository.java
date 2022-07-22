package com.yuanbao.record.search.repository;

import com.yuanbao.record.search.mapper.entity.EsProductSkus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsProductSkusRepository extends ElasticsearchRepository<EsProductSkus, String> {
    //命名规范
    Page<EsProductSkus> findByTitleOrProductNameContaining(Pageable page, String title, String productName);

    Page<EsProductSkus> findByTitleOrProductNameContainingOrderByStockDesc(Pageable page, String title, String productName);
}
