package com.yuanbao.record.mbp.vomapper;

import com.yuanbao.record.mbp.mapper.entity.Cart;
import com.yuanbao.record.mbp.vo.CartVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartVoMapper {
    CartVoMapper cartvomapper = Mappers.getMapper(CartVoMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "cart.id"),
            @Mapping(target = "userId", source = "cart.userId "),
            @Mapping(target = "productSkusId", source = "cart.productSkusId"),
            @Mapping(target = "productSkusNumber", source = "cart.productSkusNumber"),
    })
    CartVo Trans(Cart cart);
}

