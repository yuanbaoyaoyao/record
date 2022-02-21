package com.yuanbao.record.admin;

import com.yuanbao.record.admin.service.AdminUserService;
import com.yuanbao.record.mbp.mapper.AdminUserMapper;
import com.yuanbao.record.mbp.mapper.UserMapper;
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
//    @Test
//    public void testPage(){
//        Page<AdminUser> adminUserPage = new Page<>(1,5);
//        QueryWrapper<AdminUser> wrapper = new QueryWrapper<>();
//        IPage<AdminUser> page = adminUserMapper.se(adminUserPage,wrapper);
//        System.out.println(page.getRecords());
//        System.out.println(page.getPages());
//        System.out.println(page.getTotal());
//    }

//    @Test
//    void  Trans(){
//        AdminUser user=new AdminUser("1","jksdf","fdsjlk","fad");
//        AdminUserVo userVo = AdminUserVoMapper.adminuservomapper.Trans(user);//调用方法
//        System.out.println(userVo);
//    }
//    @Test
//    void test(){
//        System.out.println(datatimeToLocalDateTime(LocalDateTime.now()));
//        System.out.println(LocalDateTime.valueOf("1645406832614"));
//    }
//    public long datatimeToLocalDateTime(LocalDateTime ldt){
//        long LocalDateTime = ldt.toInstant(ZoneOffset.of("+8")).toEpochMilli();
//        return LocalDateTime;
//    }

}
