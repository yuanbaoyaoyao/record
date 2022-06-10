package com.yuanbao.record.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.UserFeedback;
import com.yuanbao.record.mbp.vo.UserFeedbackVo;

public interface UserFeedbackService extends IService<UserFeedback> {
    IPage<UserFeedbackVo> selectListSearch(Integer pageNum, Integer pageSize, IPage<UserFeedback> page, String keyword);

    int updateByPrimaryKey(UserFeedback userFeedback);
}
