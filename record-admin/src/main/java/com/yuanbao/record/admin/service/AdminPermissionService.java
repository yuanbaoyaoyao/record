package com.yuanbao.record.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.AdminPermission;

import java.util.List;

public interface AdminPermissionService extends IService<AdminPermission> {
    AdminPermission selectById(Long id);

    List<AdminPermission> selectByRoleId(Long roleId);

    List<String> selectPermissionByRoleId(Long roleId);

    int insert(AdminPermission adminPermission);
}
