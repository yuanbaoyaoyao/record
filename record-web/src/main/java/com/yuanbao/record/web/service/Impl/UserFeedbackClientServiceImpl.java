package com.yuanbao.record.web.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.mbp.mapper.UserFeedbackMapper;
import com.yuanbao.record.mbp.mapper.entity.UserFeedback;
import com.yuanbao.record.mbp.vo.UserFeedbackVo;
import com.yuanbao.record.mbp.vomapper.UserFeedbackVoMapper;
import com.yuanbao.record.web.service.UserFeedbackClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserFeedbackClientServiceImpl extends ServiceImpl<UserFeedbackMapper, UserFeedback> implements UserFeedbackClientService {

    @Autowired
    private UserFeedbackMapper userFeedbackMapper;

    @Override
    public IPage<UserFeedbackVo> selectListByUserId(Integer pageNum, Integer pageSize, IPage<UserFeedback> page, Long userId) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        IPage<UserFeedbackVo> voPage = new Page<>();
        List<UserFeedbackVo> userFeedbackVoList = new ArrayList<>();
        IPage<UserFeedback> userFeedbackIPage = userFeedbackMapper.selectListByUserId(pageNum, pageSize, page, userId);
        List<UserFeedback> userFeedbackList = userFeedbackIPage.getRecords();
        for (UserFeedback userFeedback : userFeedbackList) {
            UserFeedbackVo userFeedbackVo = UserFeedbackVoMapper.userfeedbackvomapper.Trans(userFeedback);
            userFeedbackVoList.add(userFeedbackVo);
        }
        voPage.setRecords(userFeedbackVoList);
        voPage.setCurrent(pageNum);
        voPage.setSize(pageSize);
        voPage.setTotal(userFeedbackIPage.getTotal());
        return voPage;
    }

    @Override
    public int insert(UserFeedback userFeedback) {
        return userFeedbackMapper.insert(userFeedback);
    }

    @Override
    public int updateFinished(UserFeedback userFeedback) {
        return userFeedbackMapper.updateFinished(userFeedback);
    }

}
