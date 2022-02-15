package com.yuanbao.record.mbp.vomapper;

import com.yuanbao.record.mbp.mapper.entity.AdminOperationLog;
import com.yuanbao.record.mbp.vo.AdminOperationLogVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminOperationLogVoMapper {
    AdminOperationLogVoMapper adminoperationlogvomapper = Mappers.getMapper(AdminOperationLogVoMapper.class);

    @Mappings({
            @Mapping(target = "ip", source = "adminOperationLog.ip"),
            @Mapping(target = "type", source = "adminOperationLog.type"),
            @Mapping(target = "action", source = "adminOperationLog.action"),
            @Mapping(target = "status", source = "adminOperationLog.status"),
            @Mapping(target = "result", source = "adminOperationLog.result"),
            @Mapping(target = "createdAt", source = "adminOperationLog.createdAt"),
    })
    AdminOperationLogVo Trans(AdminOperationLog adminOperationLog);
}
