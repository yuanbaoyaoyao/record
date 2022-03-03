package com.yuanbao.record.shiro.auth;

import com.yuanbao.record.mbp.mapper.entity.User;
import com.yuanbao.record.web.service.UserClientService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;


public class AuthClientRealm extends AuthorizingRealm {

    @Autowired
    @Lazy
    private UserClientService userClientService;

//    @Autowired
//    @Lazy
//    private AdminRoleService adminRoleService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) getAvailablePrincipal(principalCollection);

//        Long roleId = user.getRoleId();
//        String role = adminRoleService.getById(roleId).getName();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.addRole(role);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        String password = new String(usernamePasswordToken.getPassword());

        User user = userClientService.selectUserListByName(username);

        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误!");
        }
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("用户名或密码错误");
        }

        return new SimpleAuthenticationInfo(user, password, getName());
    }
}
