package com.yuanbao.record.mbp.vomapper;

import com.yuanbao.record.mbp.mapper.entity.UserFeedbackDetail;
import com.yuanbao.record.mbp.vo.UserFeedbackDetailVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserFeedbackDetailVoMapper {
    UserFeedbackDetailVoMapper userfeedbackdetailvomapper = Mappers.getMapper(UserFeedbackDetailVoMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "userFeedbackDetail.id"),
            @Mapping(target = "userFeedbackId", source = "userFeedbackDetail.userFeedbackId"),
            @Mapping(target = "adminUserId", source = "userFeedbackDetail.adminUserId"),
            @Mapping(target = "adminUserName", source = "userFeedbackDetail.adminUserName"),
            @Mapping(target = "content", source = "userFeedbackDetail.content"),
            @Mapping(target = "createdAt", source = "userFeedbackDetail.createdAt"),
    })
    UserFeedbackDetailVo Trans(UserFeedbackDetail userFeedbackDetail);
}
