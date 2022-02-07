package com.yuanbao.record.admin.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.entity.AdminUser;
import com.yuanbao.record.mbp.vo.AdminUserVo;

public interface AdminUserService extends IService<AdminUser> {
    IPage<AdminUserVo> selectAdminListSearch(Integer pageNum, Integer pageSize, IPage<AdminUserVo> page, String keyword);

    int insert(AdminUser adminUser);
}
