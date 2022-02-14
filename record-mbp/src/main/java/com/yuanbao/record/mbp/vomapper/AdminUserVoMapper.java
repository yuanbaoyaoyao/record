package com.yuanbao.record.mbp.vomapper;

import com.yuanbao.record.mbp.mapper.entity.AdminUser;
import com.yuanbao.record.mbp.vo.AdminUserVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminUserVoMapper {
    AdminUserVoMapper adminuservomapper = Mappers.getMapper(AdminUserVoMapper.class);

    AdminUserVo Trans(AdminUser adminUser);
}
