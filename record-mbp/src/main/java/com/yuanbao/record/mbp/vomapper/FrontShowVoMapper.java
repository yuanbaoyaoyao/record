package com.yuanbao.record.mbp.vomapper;

import com.yuanbao.record.mbp.mapper.entity.FrontShow;
import com.yuanbao.record.mbp.vo.FrontShowVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FrontShowVoMapper {
    FrontShowVoMapper frontshowvomapper = Mappers.getMapper(FrontShowVoMapper.class);
    @Mappings({
            @Mapping(target = "id", source = "frontShow.id"),
            @Mapping(target = "productSkusId", source = "frontShow.productSkusId"),
            @Mapping(target = "productSkusName", source = "frontShow.productSkusName"),
            @Mapping(target = "avatar", source = "frontShow.avatar"),
            @Mapping(target = "productName", source = "frontShow.productName"),
            @Mapping(target = "showRotation", source = "frontShow.showRotation"),
            @Mapping(target = "showOld", source = "frontShow.showOld"),
            @Mapping(target = "showNew", source = "frontShow.showNew"),
    })
    FrontShowVo Trans(FrontShow frontShow);
}