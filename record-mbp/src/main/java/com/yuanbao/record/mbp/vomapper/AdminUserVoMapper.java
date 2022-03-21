package com.yuanbao.record.mbp.vomapper;

import com.yuanbao.record.mbp.mapper.entity.AdminUser;
import com.yuanbao.record.mbp.vo.AdminUserVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminUserVoMapper {
    AdminUserVoMapper adminuservomapper = Mappers.getMapper(AdminUserVoMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "adminUser.id"),
            @Mapping(target = "name", source = "adminUser.name"),
            @Mapping(target = "password", source = "adminUser.password"),
            @Mapping(target = "avatar", source = "adminUser.avatar"),
            @Mapping(target = "role", source = "adminUser.role"),
            @Mapping(target = "createdAt", source = "adminUser.createdAt"),
    })
    AdminUserVo Trans(AdminUser adminUser);
}
