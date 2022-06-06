package com.yuanbao.record.shiro.config;

import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();

        Map<String, String> filterRuleMap = new HashMap<>();

        filterRuleMap.put("/auth/login", "anon");
        filterRuleMap.put("/auth/logout", "anon");
        filterRuleMap.put("/auth/client/login", "anon");
        filterRuleMap.put("/auth/client/sendEmailCode", "anon");
        filterRuleMap.put("/auth/client/logout", "anon");
        filterRuleMap.put("/**", "authcBearer");

        factoryBean.setGlobalFilters(Collections.singletonList("noSessionCreation"));

        factoryBean.setSecurityManager(securityManager);
        factoryBean.setFilterChainDefinitionMap(filterRuleMap);
        return factoryBean;
    }


    @Bean
    protected Authorizer authorizer() {
        ModularRealmAuthorizer authorizer = new ModularRealmAuthorizer();
        return authorizer;
    }
}
