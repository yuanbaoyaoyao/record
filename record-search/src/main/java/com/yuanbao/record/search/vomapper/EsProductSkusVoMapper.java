package com.yuanbao.record.search.vomapper;

import com.yuanbao.record.search.mapper.entity.EsProductSkus;
import com.yuanbao.record.search.vo.EsProductSkusVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EsProductSkusVoMapper {
    EsProductSkusVoMapper esproductskusvomapper = Mappers.getMapper(com.yuanbao.record.search.vomapper.EsProductSkusVoMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "productSkus.id"),
            @Mapping(target = "productId", source = "productSkus.productId"),
            @Mapping(target = "title", source = "productSkus.title"),
            @Mapping(target = "avatar", source = "productSkus.avatar"),
            @Mapping(target = "description", source = "productSkus.description"),
            @Mapping(target = "stock", source = "productSkus.stock"),
            @Mapping(target = "createdAt", source = "productSkus.createdAt"),
    })
    EsProductSkusVo Trans(EsProductSkus esProductSkus);
}