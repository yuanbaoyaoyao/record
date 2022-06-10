package com.yuanbao.record.admin.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.admin.service.UserFeedbackDetailService;
import com.yuanbao.record.mbp.mapper.UserFeedbackDetailMapper;
import com.yuanbao.record.mbp.mapper.entity.UserFeedbackDetail;
import com.yuanbao.record.mbp.vo.UserFeedbackDetailVo;
import com.yuanbao.record.mbp.vomapper.UserFeedbackDetailVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserFeedbackDetailServiceImpl extends ServiceImpl<UserFeedbackDetailMapper, UserFeedbackDetail> implements UserFeedbackDetailService {

    @Autowired
    private UserFeedbackDetailMapper userFeedbackDetailMapper;

    @Override
    public List<UserFeedbackDetailVo> selectUserFeedbackDetailByUserFeedbackId(Long userFeedbackId) {
        List<UserFeedbackDetail> userFeedbackDetailList = userFeedbackDetailMapper.selectUserFeedbackDetailByUserFeedbackId(userFeedbackId);
        List<UserFeedbackDetailVo> userFeedbackDetailVoList = new ArrayList<>();
        for (UserFeedbackDetail userFeedbackDetail : userFeedbackDetailList) {
            UserFeedbackDetailVo userFeedbackDetailVo = UserFeedbackDetailVoMapper.userfeedbackdetailvomapper.Trans(userFeedbackDetail);
            userFeedbackDetailVoList.add(userFeedbackDetailVo);
        }
        return userFeedbackDetailVoList;
    }

    @Override
    public int insert(UserFeedbackDetail userFeedbackDetail) {
        return userFeedbackDetailMapper.insert(userFeedbackDetail);
    }
}
