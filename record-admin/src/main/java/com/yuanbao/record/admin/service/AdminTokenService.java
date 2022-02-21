package com.yuanbao.record.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.AdminToken;


public interface AdminTokenService extends IService<AdminToken> {
    AdminToken selectByToken(String token);

    AdminToken selectByUserId(Long userId);

    int insert(AdminToken adminToken);

    int updateByPrimaryKey(AdminToken adminToken);
}
