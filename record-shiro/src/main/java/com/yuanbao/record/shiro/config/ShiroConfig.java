package com.yuanbao.record.shiro.config;

import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();

        Map<String, String> filterRuleMap = new LinkedHashMap<>();

        filterRuleMap.put("/auth/login", "anon");
        filterRuleMap.put("/auth/logout", "anon");
        filterRuleMap.put("/auth/client/login", "anon");
        filterRuleMap.put("/auth/client/sendEmailCode", "anon");
        filterRuleMap.put("/auth/client/logout", "anon");
        filterRuleMap.put("/**", "authcBearer");

        factoryBean.setGlobalFilters(Arrays.asList("noSessionCreation"));

        factoryBean.setSecurityManager(securityManager);
        factoryBean.setFilterChainDefinitionMap(filterRuleMap);
        return factoryBean;
    }


    @Bean
    protected Authorizer authorizer() {
        ModularRealmAuthorizer authorizer = new ModularRealmAuthorizer();
        return authorizer;
    }


//    @Bean(name = "authenticator")
//    public MyModularRealmAuthenticator modularRealmAuthorizer() {
//        MyModularRealmAuthenticator modularRealmAuthorizer = new MyModularRealmAuthenticator();
//        modularRealmAuthorizer.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
//        return modularRealmAuthorizer;
//    }
}
