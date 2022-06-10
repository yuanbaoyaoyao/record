package com.yuanbao.record.mbp.vomapper;

import com.yuanbao.record.mbp.mapper.entity.UserFeedback;
import com.yuanbao.record.mbp.vo.UserFeedbackVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserFeedbackVoMapper {
    UserFeedbackVoMapper userfeedbackvomapper = Mappers.getMapper(UserFeedbackVoMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "userFeedback.id"),
            @Mapping(target = "userId", source = "userFeedback.userId"),
            @Mapping(target = "username", source = "userFeedback.username"),
            @Mapping(target = "feedbackTitle", source = "userFeedback.feedbackTitle"),
            @Mapping(target = "feedbackPicUrl", source = "userFeedback.feedbackPicUrl"),
            @Mapping(target = "feedbackContent", source = "userFeedback.feedbackContent"),
            @Mapping(target = "isRead", source = "userFeedback.isRead"),
            @Mapping(target = "isFinished", source = "userFeedback.isFinished"),
            @Mapping(target = "createdAt", source = "userFeedback.createdAt"),
    })
    UserFeedbackVo Trans(UserFeedback userFeedback);
}
