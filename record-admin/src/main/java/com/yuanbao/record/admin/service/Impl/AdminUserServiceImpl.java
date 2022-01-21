package com.yuanbao.record.admin.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.admin.service.AdminUserService;
import com.yuanbao.record.mbp.entity.AdminUser;
import com.yuanbao.record.mbp.mapper.AdminUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper,AdminUser> implements AdminUserService {
    @Autowired
    private  AdminUserMapper adminUserMapper;

    @Override
    public List<AdminUser> selectAdminList(IPage<AdminUser> page) {
        return adminUserMapper.selectAdminList(page);
    }

    @Override
    public List<AdminUser> selectAdminAll(List<AdminUser> adminUsers) {
        return adminUserMapper.selectAdminAll(adminUsers);
    }
}
