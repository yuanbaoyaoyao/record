package com.yuanbao.record.mbp.vomapper;

import com.yuanbao.record.mbp.mapper.entity.User;
import com.yuanbao.record.mbp.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserVoMapper {
    UserVoMapper uservomapper = Mappers.getMapper(UserVoMapper.class);

    @Mappings({
            @Mapping(target = "name", source = "user.name"),
            @Mapping(target = "avatar", source = "user.avatar"),
            @Mapping(target = "email", source = "user.email"),
            @Mapping(target = "emailVerifiedAt", source = "user.emailVerifiedAt"),
            @Mapping(target = "enable", source = "user.enable"),
            @Mapping(target = "password", source = "user.password"),
            @Mapping(target = "createdAt", source = "user.createdAt"),
    })
    UserVo Trans(User user);
}
