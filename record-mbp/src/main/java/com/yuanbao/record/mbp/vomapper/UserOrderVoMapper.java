package com.yuanbao.record.mbp.vomapper;

import com.yuanbao.record.mbp.mapper.entity.UserOrder;
import com.yuanbao.record.mbp.vo.UserOrderVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserOrderVoMapper {
    UserOrderVoMapper userordervomapper = Mappers.getMapper(UserOrderVoMapper.class);

    @Mappings({
            @Mapping(target = "userId", source = "userOrder.userId"),
            @Mapping(target = "userAddressId", source = "userOrder.userAddressId"),
            @Mapping(target = "productTitle", source = "userOrder.productTitle"),
            @Mapping(target = "productSkusTitle", source = "userOrder.productSkusTitle"),
            @Mapping(target = "productNumber", source = "userOrder.productNumber"),
            @Mapping(target = "orderSn", source = "userOrder.orderSn"),
            @Mapping(target = "orderRemarks", source = "userOrder.orderRemarks"),
    })
    UserOrderVo Trans(UserOrder userOrder);
}
