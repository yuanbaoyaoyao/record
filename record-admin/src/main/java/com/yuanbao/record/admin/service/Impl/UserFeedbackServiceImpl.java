package com.yuanbao.record.admin.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.admin.service.UserFeedbackService;
import com.yuanbao.record.mbp.mapper.UserFeedbackMapper;
import com.yuanbao.record.mbp.mapper.entity.UserFeedback;
import com.yuanbao.record.mbp.vo.UserFeedbackVo;
import com.yuanbao.record.mbp.vomapper.UserFeedbackVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserFeedbackServiceImpl extends ServiceImpl<UserFeedbackMapper, UserFeedback> implements UserFeedbackService {
    @Autowired
    private UserFeedbackMapper userFeedbackMapper;


    @Override
    public IPage<UserFeedbackVo> selectListSearch(Integer pageNum, Integer pageSize, IPage<UserFeedback> page, String keyword) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        IPage<UserFeedbackVo> voPage = new Page<>();
        List<UserFeedbackVo> userFeedbackVoList = new ArrayList<>();
        IPage<UserFeedback> userFeedbackIPage = userFeedbackMapper.selectListSearch(pageNum, pageSize, page, keyword);
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
    public int updateByPrimaryKey(UserFeedback userFeedback) {
        return userFeedbackMapper.updateByPrimaryKey(userFeedback);
    }
}
