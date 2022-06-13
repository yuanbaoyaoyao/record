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
            @Mapping(target = "id", source = "userReminder.id"),
            @Mapping(target = "userId", source = "userReminder.userId"),
            @Mapping(target = "userFeedbackId", source = "userReminder.userFeedbackId"),
            @Mapping(target = "orderProductId", source = "userReminder.orderProductId"),
            @Mapping(target = "isRead", source = "userReminder.isRead"),
            @Mapping(target = "createdAt", source = "userReminder.createdAt"),
    })
    UserReminderVo Trans(UserReminder userReminder);
}
