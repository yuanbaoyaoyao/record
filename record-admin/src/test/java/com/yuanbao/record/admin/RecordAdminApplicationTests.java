package com.yuanbao.record.admin;

import com.yuanbao.record.admin.service.AdminUserService;
import com.yuanbao.record.common.api.util.SaltUtil;
import com.yuanbao.record.mbp.mapper.AdminUserMapper;
import com.yuanbao.record.mbp.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        String s = SaltUtil.generateSalt(20);
        System.out.println(s);
//        SecureRandom random = new SecureRandom();
//        byte[] bytes = new byte[16];
//        random.nextBytes(bytes);
//        System.out.println(random);
//        String s = BCrypt.gensalt(20);
//        String md5 = SecureUtil.md5("yuanbao");
//        String md5 = DigestUtil.md5Hex("yuanbao");
//        System.out.println(md5);
    }

}
