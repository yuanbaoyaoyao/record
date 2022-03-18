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
            @Mapping(target = "receiver", source = "userOrder.receiver"),
            @Mapping(target = "user", source = "userOrder.user"),
            @Mapping(target = "addressDetail", source = "userOrder.addressDetail"),
            @Mapping(target = "orderSn", source = "userOrder.orderSn"),
            @Mapping(target = "orderRemarks", source = "userOrder.orderRemarks"),
            @Mapping(target = "orderProductVoList", source = "userOrder.orderProductVoList"),

//            @Mapping(target = "countOrderNumber", source = "userOrder.countOrderNumber"),
//            @Mapping(target = "sumProductNumber", source = "userOrder.sumProductNumber"),
//            @Mapping(target = "specifiedTime1", source = "userOrder.specifiedTime1"),
//            @Mapping(target = "specifiedTime2", source = "userOrder.specifiedTime2"),
            @Mapping(target = "createdAt", source = "userOrder.createdAt"),
    })
    UserOrderVo Trans(UserOrder userOrder);
}
