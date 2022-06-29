package com.yuanbao.record.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuanbao.record.mbp.mapper.AdminPermissionMapper;
import com.yuanbao.record.mbp.mapper.entity.AdminPermission;
import com.yuanbao.record.shiro.service.ShiroAdminPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ShiroAdminPermissionServiceImpl extends ServiceImpl<AdminPermissionMapper, AdminPermission> implements ShiroAdminPermissionService {
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
        for (AdminPermission adminPermission : adminPermissionList) {
            adminPermissions.add(adminPermission.getPermission());
        }
        return adminPermissions;
    }

    @Override
    public boolean checkSuperPermission(Long roleId) {
        List<AdminPermission> adminPermissionList = adminPermissionMapper.selectByRoleId(roleId);
        if(Objects.equals(adminPermissionList.get(0).getPermission(), "*")){
            return true;
        }
        return false;
    }

    @Override
    public int insert(AdminPermission adminPermission) {
        return adminPermissionMapper.insert(adminPermission);
    }

    @Override
    public int deleteByRoleId(Long RoleId) {
        return adminPermissionMapper.deleteByRoleId(RoleId);
    }
}
