package com.yuanbao.record.mbp.vomapper;

import com.yuanbao.record.mbp.mapper.entity.ProductSkusDetails;
import com.yuanbao.record.mbp.vo.ProductSkusDetailsVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductSkusDetailsVoMapper {
    ProductSkusDetailsVoMapper productskusdetailvomapper = Mappers.getMapper(ProductSkusDetailsVoMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "productSkusDetails.id"),
            @Mapping(target = "productId", source = "productSkusDetails.productId"),
            @Mapping(target = "avatar", source = "productSkusDetails.avatar"),
            @Mapping(target = "sequence", source = "productSkusDetails.sequence"),
            @Mapping(target = "createdAt", source = "productSkusDetails.createdAt"),
    })
    ProductSkusDetailsVo Trans(ProductSkusDetails productSkusDetails);
}
