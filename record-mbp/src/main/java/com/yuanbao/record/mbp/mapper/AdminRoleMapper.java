package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuanbao.record.mbp.mapper.entity.AdminRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminRoleMapper extends BaseMapper<AdminRole> {
    IPage<AdminRole> selectRoleList(Integer pageNum, Integer pageSize, IPage<AdminRole> page, String name,Long id);

    AdminRole selectById(Integer integer);

    int insert(AdminRole adminRole);

    int updateByPrimaryKey(AdminRole adminRole);
}
