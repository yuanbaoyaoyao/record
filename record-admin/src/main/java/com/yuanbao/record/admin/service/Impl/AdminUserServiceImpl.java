package com.yuanbao.record.admin.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.admin.service.AdminUserService;
import com.yuanbao.record.mbp.entity.AdminUser;
import com.yuanbao.record.mbp.mapper.AdminUserMapper;
import com.yuanbao.record.mbp.vo.AdminUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements AdminUserService {
    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    public IPage<AdminUserVo> selectAdminList(Integer pageNum, Integer pageSize, IPage<AdminUser> page) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        return adminUserMapper.selectAdminList(pageNum,pageSize,page);
    }
}
