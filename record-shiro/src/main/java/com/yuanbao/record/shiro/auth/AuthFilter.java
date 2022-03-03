package com.yuanbao.record.shiro.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuanbao.record.common.api.CommonResult;
import com.yuanbao.record.common.api.util.HttpContextUtil;
import com.yuanbao.record.common.api.util.TokenUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthFilter extends AuthenticatingFilter {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        String token = TokenUtil.getRequestToken((HttpServletRequest) servletRequest);
        return new AuthToken(token);
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (((HttpServletRequest) request).getMethod().equals(RequestMethod.OPTIONS.name())) {
            return true;
        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        String token = TokenUtil.getRequestToken((HttpServletRequest) servletRequest);
        if (StringUtils.isBlank(token)) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
            httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
            httpServletResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtil.getOrigin());
            httpServletResponse.setCharacterEncoding("UTF-8");
            String json = MAPPER.writeValueAsString(CommonResult.unauthorized(401));
            httpServletResponse.getWriter().print(json);
            return false;
        }
        return executeLogin(servletRequest, servletResponse);
    }

    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpServletResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtil.getOrigin());
        httpServletResponse.setCharacterEncoding("UTF-8");
        try {
            Throwable throwable = e.getCause() == null ? e : e.getCause();
            String json = MAPPER.writeValueAsString(CommonResult.forbidden(401));
            httpServletResponse.getWriter().print(json);
        } catch (IOException e1) {
        }
        return false;
    }
}
