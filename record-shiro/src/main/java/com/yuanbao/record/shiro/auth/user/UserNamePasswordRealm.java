//package com.yuanbao.record.shiro.auth.user;
//
//import com.yuanbao.record.common.api.constant.Constant;
//import com.yuanbao.record.mbp.mapper.entity.JwtUser;
//import com.yuanbao.record.mbp.mapper.entity.User;
//import com.yuanbao.record.web.service.UserClientService;
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
//public class UserNamePasswordRealm extends AuthenticatingRealm {
//
//    @Autowired
//    private UserClientService userClientService;
//
//    @Override
//    public String getName() {
//        return Constant.TOKEN_REALM_NAME;
//    }
//
//    @Override
//    public boolean supports(AuthenticationToken token) {
//        //继承但啥都不做就为了打印一下info
//        boolean res = super.supports(token);//会调用↑getAuthenticationTokenClass来判断
//        System.out.println("[UsernamePasswordRealm is supports]" + res);
//        return res;
//    }
//
//    public UserNamePasswordRealm() {
//        super();
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//        hashedCredentialsMatcher.setHashAlgorithmName("md5");
//        hashedCredentialsMatcher.setHashIterations(2);
//        this.setCredentialsMatcher(hashedCredentialsMatcher);
//    }
//
//    @Override
//    public Class getAuthenticationTokenClass() {
//        return UsernamePasswordToken.class;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) {
//        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
//        User user = userClientService.selectUserListByName(usernamePasswordToken.getUsername());
//        String password = user.getPassword();
//        String salt = user.getSalt();
//        System.out.println("yes");
//        JwtUser jwtUser = new JwtUser(user.getName());
//        return new SimpleAuthenticationInfo((PrincipalCollection) jwtUser, password, ByteSource.Util.bytes(salt));
//    }
//}
