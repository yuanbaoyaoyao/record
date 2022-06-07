package com.yuanbao.record.search.mapper;

import com.yuanbao.record.search.mapper.entity.EsProductSkus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EsProductSkusMapper {
    List<EsProductSkus> selectEsProductSkusList();
}
