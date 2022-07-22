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
            @Mapping(target = "orderSn", source = "orderProduct.orderSn"),
            @Mapping(target = "productId", source = "orderProduct.productId"),
            @Mapping(target = "orderStatus", source = "orderProduct.orderStatus"),
            @Mapping(target = "productSkusId", source = "orderProduct.productSkusId"),
            @Mapping(target = "receiver", source = "orderProduct.receiver"),
            @Mapping(target = "productTitle", source = "orderProduct.productTitle"),
            @Mapping(target = "productSkusTitle", source = "orderProduct.productSkusTitle"),
            @Mapping(target = "countOrderNumber", source = "orderProduct.countOrderNumber"),
            @Mapping(target = "sumProductNumber", source = "orderProduct.sumProductNumber"),
            @Mapping(target = "number", source = "orderProduct.number"),
            @Mapping(target = "productPicUrl", source = "orderProduct.productPicUrl"),
            @Mapping(target = "createdAt", source = "orderProduct.createdAt"),
            @Mapping(target = "updatedAt", source = "orderProduct.updatedAt"),

    })
    OrderProductVo Trans(OrderProduct orderProduct);
}
