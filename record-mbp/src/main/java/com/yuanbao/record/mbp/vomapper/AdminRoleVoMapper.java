package com.yuanbao.record.mbp.vomapper;

import com.yuanbao.record.mbp.mapper.entity.AdminRole;
import com.yuanbao.record.mbp.vo.AdminRoleVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminRoleVoMapper {
    AdminRoleVoMapper adminrolevomapper = Mappers.getMapper(AdminRoleVoMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "adminRole.id"),
            @Mapping(target = "name", source = "adminRole.name"),
            @Mapping(target = "description", source = "adminRole.description"),
            @Mapping(target = "createdAt", source = "adminRole.createdAt"),
    })
    AdminRoleVo Trans(AdminRole adminRole);
}
