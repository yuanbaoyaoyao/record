package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuanbao.record.mbp.mapper.entity.UserFeedbackDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserFeedbackDetailMapper extends BaseMapper<UserFeedbackDetail> {
    List<UserFeedbackDetail> selectUserFeedbackDetailByUserFeedbackId(Long userFeedbackId);

    int insert(UserFeedbackDetail userFeedbackDetail);
}
