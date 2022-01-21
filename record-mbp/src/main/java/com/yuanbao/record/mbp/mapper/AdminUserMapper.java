package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuanbao.record.mbp.entity.AdminUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminUserMapper extends BaseMapper<AdminUser> {
    List<AdminUser> selectAdminList(IPage<AdminUser> page);

//    test
    List<AdminUser> selectAdminAll(List<AdminUser> adminUsers);
}
