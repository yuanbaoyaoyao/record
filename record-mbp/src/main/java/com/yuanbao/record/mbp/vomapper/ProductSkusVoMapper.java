package com.yuanbao.record.mbp.vomapper;

import com.yuanbao.record.mbp.mapper.entity.ProductSkus;
import com.yuanbao.record.mbp.vo.ProductSkusVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductSkusVoMapper {
    ProductSkusVoMapper productskusvomapper = Mappers.getMapper(ProductSkusVoMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "productSkus.id"),
            @Mapping(target = "productId", source = "productSkus.productId"),
            @Mapping(target = "title", source = "productSkus.title"),
            @Mapping(target = "avatar", source = "productSkus.avatar"),
            @Mapping(target = "description", source = "productSkus.description"),
            @Mapping(target = "stock", source = "productSkus.stock"),
            @Mapping(target = "createdAt", source = "productSkus.createdAt"),
    })
    ProductSkusVo Trans(ProductSkus productSkus);
}
