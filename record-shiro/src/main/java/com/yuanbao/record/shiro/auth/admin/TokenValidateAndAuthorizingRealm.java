package com.yuanbao.record.shiro.auth.admin;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.yuanbao.record.admin.service.AdminUserService;
import com.yuanbao.record.common.util.JwtUtil;
import com.yuanbao.record.mbp.mapper.entity.JwtUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//验证token与鉴权realm
@Slf4j
@Component
public class TokenValidateAndAuthorizingRealm extends AuthorizingRealm {
//为了有鉴权方法，最高只能继承AuthorizingRealm，但是这个父类会自动生成一个SimpleCredentialsMatcher强制走matcher。只能说这套Realm的继承树不够成熟
//鉴权方法放到usernamePasswordRealm里实现也可以，这样这个Realm可以直接继承Realm，最清爽简洁。但是逻辑上应该放这里，毕竟除了login之外的所有业务接口都靠这个realm验证身份。且u+p的验证方式是可选项，jwt的必然存在

    AdminUserService adminUserService;

    Map<String, Collection<String>> rolePermissionsMap;

    @Autowired
    public void setAdminUserService(AdminUserService adminUserService){
        this.adminUserService = adminUserService;
    }

    public TokenValidateAndAuthorizingRealm() {
        //CredentialsMatcher，自定义匹配策略（即验证jwt token的策略）
        super((authenticationToken, authenticationInfo) -> {
            log.info("doCredentialsMatch token合法性验证");
            BearerToken bearerToken = (BearerToken) authenticationToken;
            String bearerTokenString = bearerToken.getToken();
            log.debug(bearerTokenString);

            return JwtUtil.verifyTokenOfUser(bearerTokenString);
        });
    }

    @Override
    public String getName() {
        return "TokenValidateAndAuthorizingRealm";
    }

    @Override
    public Class getAuthenticationTokenClass() {
        //设置由本realm处理的token类型。BearerToken是在filter里自动装配的。
        return BearerToken.class;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        boolean res=super.supports(token);
        log.debug("[TokenValidateRealm is supports]" + res);
        return res;
    }


    @Override//鉴权部分
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.debug("doGetAuthorizationInfo 权限验证");

        JwtUser user = (JwtUser) SecurityUtils.getSubject().getPrincipal();

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        simpleAuthorizationInfo.addRoles(user.getRoles());//roles跟着user走，放到token里。普通功能直接用token中的。只有在重要操作时才需去数据库验一遍，减轻压力

        Set<String> stringPermissions = new HashSet<String>();
//        for (String role : user.getRoles()) {
//            stringPermissions.addAll(rolePermissionsMap.get(role));
//        }
        simpleAuthorizationInfo.addStringPermissions(stringPermissions);
        return simpleAuthorizationInfo;
    }

    @Override//装配用户信息，供Matcher调用
    public AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException, TokenExpiredException {
        log.debug("doGetAuthenticationInfo 将token装载成用户信息");

        BearerToken bearerToken = (BearerToken) authenticationToken;
        String bearerTokenString = bearerToken.getToken();

        JwtUser jwtUser = JwtUtil.recreateUserFromToken(bearerTokenString);//只带着用户名和roles

        SimpleAuthenticationInfo res = new SimpleAuthenticationInfo(jwtUser, bearerTokenString, this.getName());
        /*Constructor that takes in an account's identifying principal(s) and its corresponding credentials that verify the principals.*/
//        这个返回值是造Subject用的，返回值供createSubject使用
        return res;
    }

}
