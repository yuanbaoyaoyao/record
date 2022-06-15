package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuanbao.record.mbp.mapper.entity.UserFeedback;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserFeedbackMapper extends BaseMapper<UserFeedback> {
    IPage<UserFeedback> selectListSearch(Integer pageNum, Integer pageSize, IPage<UserFeedback> page, String keyword);

    IPage<UserFeedback> selectListByUserId(Integer pageNum, Integer pageSize, IPage<UserFeedback> page, Long userId);

    int updateByPrimaryKey(UserFeedback userFeedback);

    int insert(UserFeedback userFeedback);

    int updateFinished(UserFeedback userFeedback);

}
