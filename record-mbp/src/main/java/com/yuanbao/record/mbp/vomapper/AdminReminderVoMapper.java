package com.yuanbao.record.mbp.vomapper;

import com.yuanbao.record.mbp.mapper.entity.AdminReminder;
import com.yuanbao.record.mbp.vo.AdminReminderVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminReminderVoMapper {
    AdminReminderVoMapper adminremindervomapper = Mappers.getMapper(AdminReminderVoMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "adminReminder.id"),
            @Mapping(target = "userFeedbackId", source = "adminReminder.userFeedbackId"),
            @Mapping(target = "orderProductId", source = "adminReminder.orderProductId"),
            @Mapping(target = "productSkusId", source = "adminReminder.productSkusId"),
            @Mapping(target = "isRead", source = "adminReminder.isRead"),
            @Mapping(target = "createdAt", source = "adminReminder.createdAt"),
    })
    AdminReminderVo Trans(AdminReminder adminReminder);
}
