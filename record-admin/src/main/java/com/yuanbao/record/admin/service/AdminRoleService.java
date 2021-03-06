package com.yuanbao.record.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.AdminRole;
import com.yuanbao.record.mbp.vo.AdminRoleVo;

public interface AdminRoleService extends IService<AdminRole> {
    IPage<AdminRoleVo> selectRoleList(Integer pageNum, Integer pageSize, IPage<AdminRole> page, String name,Long id);

    String selectNameById(Long id);

    int insert(AdminRole adminRole);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKey(AdminRole adminRole);

}
