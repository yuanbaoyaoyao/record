package com.yuanbao.record.mbp.vomapper;

import com.yuanbao.record.mbp.mapper.entity.Product;
import com.yuanbao.record.mbp.vo.ProductVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductVoMapper {
    ProductVoMapper productvomapper = Mappers.getMapper(ProductVoMapper.class);

    @Mappings({
            @Mapping(target = "title", source = "product.title"),
            @Mapping(target = "description", source = "product.description"),
            @Mapping(target = "createdAt", source = "product.createdAt"),
    })
    ProductVo Trans(Product product);
}
