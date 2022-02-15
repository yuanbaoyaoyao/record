package com.yuanbao.record.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuanbao.record.mbp.mapper.entity.AdminUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminUserMapper extends BaseMapper<AdminUser> {
    IPage<AdminUser> selectAdminListSearch(Integer pageNum, Integer pageSize, IPage<AdminUser> page, String keyword);

//    List<AdminUser> selectAdminListSearch(List<AdminUser> adminUserList, String keyword);

    int insert(AdminUser adminUser);

    int updateByPrimaryKey(AdminUser adminUser);
}
