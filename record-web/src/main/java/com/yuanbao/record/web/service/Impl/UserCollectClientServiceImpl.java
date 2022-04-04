package com.yuanbao.record.web.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.mbp.mapper.UserCollectMapper;
import com.yuanbao.record.mbp.mapper.entity.UserCollect;
import com.yuanbao.record.mbp.vo.UserCollectVo;
import com.yuanbao.record.mbp.vomapper.UserCollectVoMapper;
import com.yuanbao.record.web.service.UserCollectClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserCollectClientServiceImpl extends ServiceImpl<UserCollectMapper, UserCollect> implements UserCollectClientService {

    @Autowired
    private UserCollectMapper userCollectMapper;

    @Override
    public IPage<UserCollectVo> selectProductSkusByUserId(Integer pageNum, Integer pageSize, IPage<UserCollect> page, Long productSkusId) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        IPage<UserCollectVo> voPage = new Page<>();
        List<UserCollectVo> userCollectVoList = new ArrayList<>();
        IPage<UserCollect> userCollectIPage = userCollectMapper.selectProductSkusByUserId(pageNum, pageSize, page, productSkusId);
        List<UserCollect> userCollectList = userCollectIPage.getRecords();
        for (UserCollect userCollect : userCollectList) {
            UserCollectVo userCollectVo = UserCollectVoMapper.usercollectvomapper.Trans(userCollect);
            userCollectVoList.add(userCollectVo);
        }
        voPage.setRecords(userCollectVoList);
        voPage.setCurrent(pageNum);
        voPage.setSize(pageSize);
        voPage.setTotal(userCollectIPage.getTotal());
        return voPage;
    }

    @Override
    public List<UserCollectVo> selectIDByUserIdAndProuductSkusId(Long userId, Long productSkusId) {
        return userCollectMapper.selectIDByUserIdAndProuductSkusId(userId,productSkusId);
    }

    @Override
    public int insert(UserCollect userCollect) {
        return userCollectMapper.insert(userCollect);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userCollectMapper.deleteById(id);
    }
}
