package com.yuanbao.record.mbp.vomapper;

import com.yuanbao.record.mbp.mapper.entity.OrderProduct;
import com.yuanbao.record.mbp.vo.OrderProductVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderProductVoMapper {
    OrderProductVoMapper orderproductvomapper = Mappers.getMapper(OrderProductVoMapper.class);

    @Mappings({
            @Mapping(target = "userOrderId", source = "orderProduct.userOrderId"),
            @Mapping(target = "productId", source = "orderProduct.productId"),
            @Mapping(target = "productSkusId", source = "orderProduct.productSkusId"),
            @Mapping(target = "productTitle", source = "orderProduct.productTitle"),
            @Mapping(target = "productSkusTitle", source = "orderProduct.productSkusTitle"),
            @Mapping(target = "number", source = "orderProduct.number"),
            @Mapping(target = "createdAt", source = "orderProduct.createdAt"),
    })
    OrderProductVo Trans(OrderProduct orderProduct);
}
