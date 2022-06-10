package com.yuanbao.record.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.UserFeedbackDetail;
import com.yuanbao.record.mbp.vo.UserFeedbackDetailVo;

import java.util.List;

public interface UserFeedbackDetailService extends IService<UserFeedbackDetail> {
    List<UserFeedbackDetailVo> selectUserFeedbackDetailByUserFeedbackId(Long userFeedbackId);

    int insert(UserFeedbackDetail userFeedbackDetail);
}
