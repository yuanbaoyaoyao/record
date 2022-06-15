package com.yuanbao.record.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.UserFeedback;
import com.yuanbao.record.mbp.vo.UserFeedbackVo;

public interface UserFeedbackClientService extends IService<UserFeedback> {
    IPage<UserFeedbackVo> selectListByUserId(Integer pageNum, Integer pageSize, IPage<UserFeedback> page, Long userId);

    int insert(UserFeedback userFeedback);

    int updateFinished(UserFeedback userFeedback);

}

