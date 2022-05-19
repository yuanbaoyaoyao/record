//package com.yuanbao.record.shiro.auth.admin;
//
//import com.yuanbao.record.admin.service.AdminUserService;
//import com.yuanbao.record.mbp.mapper.entity.AdminUser;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.SimpleAuthenticationInfo;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
//import org.apache.shiro.realm.AuthenticatingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.util.ByteSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class AdminNamePasswordRealm extends AuthenticatingRealm {
//
//    @Autowired
//    private AdminUserService adminUserService;
//
//    public AdminNamePasswordRealm() {
//        super();
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//        hashedCredentialsMatcher.setHashAlgorithmName("md5");
//        hashedCredentialsMatcher.setHashIterations(2);
//        this.setCredentialsMatcher(hashedCredentialsMatcher);
//    }
//
////    @Override
////    public Class getAuthenticationTokenClass() {
////        return UsernamePasswordToken.class;
////    }
//
//    @Override
//    public boolean supports(AuthenticationToken token) {
//        //继承但啥都不做就为了打印一下info
//        boolean res = super.supports(token);//会调用↑getAuthenticationTokenClass来判断
//        System.out.println("[AdminNamePasswordRealm is supports]" + res);
//        return res;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) {
//        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
//        AdminUser adminUser = adminUserService.selectAdminListByName(usernamePasswordToken.getUsername());
//        String password = adminUser.getPassword();
//        String salt = adminUser.getSalt();
//
//        return new SimpleAuthenticationInfo((PrincipalCollection) adminUser, password, ByteSource.Util.bytes(salt));
//    }
//}
