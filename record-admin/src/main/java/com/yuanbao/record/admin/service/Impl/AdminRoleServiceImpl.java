package com.yuanbao.record.admin.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.admin.service.AdminRoleService;
import com.yuanbao.record.mbp.mapper.entity.AdminRole;
import com.yuanbao.record.mbp.mapper.AdminRoleMapper;
import com.yuanbao.record.mbp.vo.AdminRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements AdminRoleService {
    @Autowired
    private AdminRoleMapper adminRoleMapper;

    @Override
    public IPage<AdminRoleVo> selectRoleList(Integer pageNum, Integer pageSize, IPage<AdminRoleVo> page, String keyword) {
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        return adminRoleMapper.selectRoleList(pageNum, pageSize, page, keyword);
    }

    @Override
    public int insert(AdminRole adminRole) {
        int id = adminRoleMapper.insert(adminRole);
        return id;
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return adminRoleMapper.deleteById(id);
    }

    @Override
    public int updateByPrimaryKey(AdminRole adminRole) {
        return adminRoleMapper.updateByPrimaryKey(adminRole);
    }
}
