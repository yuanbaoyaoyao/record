package com.yuanbao.record.shiro.auth;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import com.alibaba.druid.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

public class WebSessionManager extends DefaultWebSessionManager {
    public static final String LOGIN_TOKEN_KEY = "X-Record-Admin-Token";
    private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";

    public WebSessionManager() {
        super();
        setGlobalSessionTimeout(MILLIS_PER_HOUR * 6);
        setSessionIdUrlRewritingEnabled(false);
    }

    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        String id = WebUtils.toHttp(request).getHeader(LOGIN_TOKEN_KEY);
        if (!StringUtils.isEmpty(id)) {
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_SOURCE);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return id;
        } else {
            return super.getSessionId(request, response);
        }
    }
}
