package com.yuanbao.record.admin;

import com.yuanbao.record.admin.service.AdminUserService;
import com.yuanbao.record.mbp.mapper.AdminUserMapper;
import com.yuanbao.record.mbp.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.SecureRandom;

@SpringBootTest
class RecordAdminApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Autowired
    private AdminUserService adminUserService;

//    单表
    @Test
    public void test() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[16];
        random.nextBytes(bytes);
        System.out.println(random);
    }

}
