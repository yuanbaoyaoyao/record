package com.yuanbao.record.shiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.AdminPermission;

import java.util.List;

public interface ShiroAdminPermissionService extends IService<AdminPermission> {
    AdminPermission selectById(Long id);

    List<AdminPermission> selectByRoleId(Long roleId);

    List<String> selectPermissionByRoleId(Long roleId);

    boolean checkSuperPermission(Long roleId);

    int insert(AdminPermission adminPermission);

    int deleteByRoleId(Long id);
}
