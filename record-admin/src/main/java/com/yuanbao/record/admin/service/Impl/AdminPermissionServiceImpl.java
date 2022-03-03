package com.yuanbao.record.admin.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.admin.service.AdminPermissionService;
import com.yuanbao.record.mbp.mapper.AdminPermissionMapper;
import com.yuanbao.record.mbp.mapper.entity.AdminPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminPermissionServiceImpl extends ServiceImpl<AdminPermissionMapper, AdminPermission> implements AdminPermissionService {
    @Autowired
    private AdminPermissionMapper adminPermissionMapper;

    @Override
    public AdminPermission selectById(Long id) {
        return adminPermissionMapper.selectById(id);
    }

    @Override
    public List<AdminPermission> selectByRoleId(Long roleId) {
        return adminPermissionMapper.selectByRoleId(roleId);
    }

    @Override
    public List<String> selectPermissionByRoleId(Long roleId) {
        List<AdminPermission> adminPermissionList = adminPermissionMapper.selectByRoleId(roleId);
        List<String> adminPermissions = new ArrayList<>();
        for(AdminPermission adminPermission : adminPermissionList){
            adminPermissions.add(adminPermission.getPermission());
        }
        return adminPermissions;
    }

    @Override
    public int insert(AdminPermission adminPermission) {
        int id = adminPermissionMapper.insert(adminPermission);
        return id;
    }
}
