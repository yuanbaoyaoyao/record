package com.yuanbao.record.search.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuanbao.record.search.mapper.entity.EsProductSkus;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsProductSkusRepository extends ElasticsearchRepository<EsProductSkus, String> {
    //命名规范
    IPage<EsProductSkus> findByTitleOrProductName(Integer pageNum, Integer pageSize, IPage<EsProductSkus> page, String title, String productName);
}
