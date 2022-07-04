package com.yuanbao.record.mbp.vomapper;

import com.yuanbao.record.mbp.mapper.entity.UserCollect;
import com.yuanbao.record.mbp.vo.UserCollectVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserCollectVoMapper {
    UserCollectVoMapper usercollectvomapper = Mappers.getMapper(UserCollectVoMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "userCollect.id"),
            @Mapping(target = "productSkusId", source = "userCollect.productSkusId"),
            @Mapping(target = "avatar", source = "userCollect.avatar"),
            @Mapping(target = "title", source = "userCollect.title"),
            @Mapping(target = "productName", source = "userCollect.productName"),
            @Mapping(target = "description", source = "userCollect.description"),
            @Mapping(target = "stock", source = "userCollect.stock"),
            @Mapping(target = "createdAt", source = "userCollect.createdAt"),
    })
    UserCollectVo Trans(UserCollect userCollect);
}
