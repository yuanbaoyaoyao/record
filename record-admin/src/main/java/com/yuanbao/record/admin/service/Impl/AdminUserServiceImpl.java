package com.yuanbao.record.admin.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.admin.service.AdminUserService;
import com.yuanbao.record.mbp.mapper.entity.AdminUser;
import com.yuanbao.record.mbp.mapper.AdminUserMapper;
import com.yuanbao.record.mbp.vo.AdminUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements AdminUserService {
    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    public IPage<AdminUserVo> selectAdminListSearch(Integer pageNum, Integer pageSize, IPage<AdminUserVo> page, String keyword) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        return adminUserMapper.selectAdminListSearch(pageNum, pageSize, page, keyword);
    }

    @Override
    public int insert(AdminUser adminUser) {
        int id = adminUserMapper.insert(adminUser);
        return id;
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return adminUserMapper.deleteById(id);
    }

    @Override
    public int updateByPrimaryKey(AdminUser adminUser) {
        return adminUserMapper.updateByPrimaryKey(adminUser);
    }


}