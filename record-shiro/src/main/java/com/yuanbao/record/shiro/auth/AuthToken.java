//package com.yuanbao.record.shiro.auth;
//
//import com.yuanbao.record.common.api.constant.Constant;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.apache.shiro.authc.UsernamePasswordToken;
//
//@Data
//@NoArgsConstructor
//public class AuthToken extends UsernamePasswordToken {
//    private String token;
//    private String loginType;
//
//
//    public AuthToken(final String username, final String password,final String token,
//                       final String loginType) {
//        super(username, password);
//        this.token = token;
//        this.loginType = loginType;
//    }
//
//    @Override
//    public Object getCredentials() {
//        if (Constant.TOKEN_REALM_NAME.equals(this.getLoginType())){
//            return getToken();
//        }
//        return getPassword();
//    }
//}
