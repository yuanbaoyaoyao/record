package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuanbao.record.mbp.entity.AdminUser;
import com.yuanbao.record.mbp.vo.AdminUserVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminUserMapper extends BaseMapper<AdminUser> {
    IPage<AdminUserVo> selectAdminList(Integer pageNum, Integer pageSize, IPage<AdminUser> page);
}