package com.yuanbao.record.mbp.vomapper;

import com.yuanbao.record.mbp.mapper.entity.ProductApply;
import com.yuanbao.record.mbp.vo.ProductApplyVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductApplyVoMapper {
    ProductApplyVoMapper productapplyvomapper = Mappers.getMapper(ProductApplyVoMapper.class);

    @Mappings({
            @Mapping(target = "userId", source = "productApply.userId"),
            @Mapping(target = "productTitle", source = "productApply.productTitle"),
            @Mapping(target = "productSkusTitle", source = "productApply.productSkusTitle"),
            @Mapping(target = "productNumber", source = "productApply.productNumber"),
            @Mapping(target = "productDetail", source = "productApply.productDetail"),
            @Mapping(target = "productState", source = "productApply.productState"),
            @Mapping(target = "createdAt", source = "productApply.createdAt"),
    })
    ProductApplyVo Trans(ProductApply productApply);
}
