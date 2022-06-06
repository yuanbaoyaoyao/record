package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuanbao.record.mbp.mapper.entity.AdminPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminPermissionMapper extends BaseMapper<AdminPermission> {

    AdminPermission selectById(Long id);

    List<AdminPermission> selectByRoleId(Long roleId);

    int insert(AdminPermission adminPermission);

    int deleteByRoleId(Long RoleId);

}
