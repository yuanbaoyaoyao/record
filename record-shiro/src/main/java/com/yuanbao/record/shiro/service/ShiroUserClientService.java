package com.yuanbao.record.shiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuanbao.record.mbp.mapper.entity.User;

public interface ShiroUserClientService extends IService<User> {
    User selectUserListByName(String userName);

    User selectUserByEmail(String email);

    int register(User user);

    int forget(User user);

    int updateByPrimaryKey(User user);

    int updateAvatarByPrimaryKey(User user);

    Boolean isExistEmail(String email);

    void sendMailCode(String email);

}
