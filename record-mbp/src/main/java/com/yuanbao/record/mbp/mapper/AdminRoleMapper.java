package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuanbao.record.mbp.mapper.entity.AdminRole;
import com.yuanbao.record.mbp.vo.AdminRoleVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminRoleMapper extends BaseMapper<AdminRole> {
    IPage<AdminRoleVo> selectRoleList(Integer pageNum, Integer pageSize, IPage<AdminRoleVo> page, String keyword);

    int insert(AdminRole adminRole);

    int updateByPrimaryKey(AdminRole adminRole);
}
