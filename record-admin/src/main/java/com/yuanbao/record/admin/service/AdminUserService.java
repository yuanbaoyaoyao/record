package com.yuanbao.record.admin.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.entity.AdminUser;

import java.util.List;

public interface AdminUserService extends IService<AdminUser> {
    List<AdminUser> selectAdminList(IPage<AdminUser> page);

//    test
    List<AdminUser> selectAdminAll(List<AdminUser> adminUsers);
}
