//package com.yuanbao.record.shiro.auth;
//
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
//import org.apache.shiro.realm.Realm;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//public class MyModularRealmAuthenticator extends ModularRealmAuthenticator {
//    @Override
//    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken) {
//        assertRealmsConfigured();
//        System.out.println("authenticationToken:" + authenticationToken);
//        AuthToken authToken = (AuthToken) authenticationToken;
//        String loginType = authToken.getLoginType();
//        Collection<Realm> realms = getRealms();
//        List<Realm> typeRealms = new ArrayList<>();
//        for (Realm realm : realms) {
//            if (realm.getName().contains(loginType)) {
//                typeRealms.add(realm);
//            }
//        }
//        if (typeRealms.size() == 1) {
//            return doSingleRealmAuthentication(typeRealms.get(0), authToken);
//        } else {
//            return doMultiRealmAuthentication(typeRealms, authToken);
//        }
//    }
//}
