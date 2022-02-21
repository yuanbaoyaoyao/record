package com.yuanbao.record.shiro.auth;

import com.yuanbao.record.admin.service.AdminRoleService;
import com.yuanbao.record.admin.service.AdminUserService;
import com.yuanbao.record.mbp.mapper.entity.AdminUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;


public class AuthRealm extends AuthorizingRealm {

    @Autowired
    @Lazy
    private AdminUserService adminUserService;

    @Autowired
    @Lazy
    private AdminRoleService adminRoleService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        AdminUser adminUser = (AdminUser) getAvailablePrincipal(principalCollection);

        Integer roleId = adminUser.getRoleId();
        String role = adminRoleService.getById(roleId).getName();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole(role);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        String password = new String(usernamePasswordToken.getPassword());

        AdminUser adminUser = adminUserService.selectAdminListByName(username);

        if (adminUser == null) {
            throw new UnknownAccountException("用户名或密码错误!");
        }
        if (!password.equals(adminUser.getPassword())) {
            throw new IncorrectCredentialsException("用户名或密码错误");
        }

        return new SimpleAuthenticationInfo(adminUser, password, getName());
    }
}
