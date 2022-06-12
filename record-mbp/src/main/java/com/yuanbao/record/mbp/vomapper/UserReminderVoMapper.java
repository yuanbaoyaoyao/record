package com.yuanbao.record.mbp.vomapper;

import com.yuanbao.record.mbp.mapper.entity.UserReminder;
import com.yuanbao.record.mbp.vo.UserReminderVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserReminderVoMapper {
    UserReminderVoMapper userremindervomapper = Mappers.getMapper(UserReminderVoMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "adminReminder.id"),
            @Mapping(target = "userId", source = "adminReminder.userId"),
            @Mapping(target = "userFeedbackId", source = "adminReminder.userFeedbackId"),
            @Mapping(target = "orderProductId", source = "adminReminder.orderProductId"),
            @Mapping(target = "isRead", source = "adminReminder.isRead"),
            @Mapping(target = "createdAt", source = "adminReminder.createdAt"),
    })
    UserReminderVo Trans(UserReminder userReminder);
}
