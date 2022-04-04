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
            @Mapping(target = "userId", source = "userCollect.userId"),
            @Mapping(target = "productSkusId", source = "userCollect.productSkusId"),
            @Mapping(target = "createdAt", source = "userCollect.createdAt"),
    })
    UserCollectVo Trans(UserCollect userCollect);
}
