package com.yuanbao.record.common.aop;

import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.common.annotation.OperationLog;
import com.yuanbao.record.common.util.IpUtil;
import com.yuanbao.record.common.util.JwtUtil;
import com.yuanbao.record.mbp.mapper.AdminOperationLogMapper;
import com.yuanbao.record.mbp.vo.AdminOperationLogVo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

@Aspect
@Component
@Slf4j
public class LogInfoAspect {

    @Autowired
    private AdminOperationLogMapper adminOperationLogMapper;

    private static String tempToken;

    public static void getTempToken(String loginToken) {
        tempToken = loginToken;
    }

    //    @Pointcut("execution(public * com.yuanbao.record.admin.controller.*.*(..))")
    @Pointcut("@annotation(com.yuanbao.record.common.annotation.OperationLog)")
    public void loginInfo() {
    }

    @AfterReturning(returning = "commonResult", pointcut = "loginInfo()&&@annotation(operationLog)")
    public void doAfterReturning(CommonResult<?> commonResult, OperationLog operationLog) {
        AdminOperationLogVo operationLogVo = new AdminOperationLogVo();

        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();

        LocalDateTime localDateTime = LocalDateTime.now();

        String token = request.getHeader("token");
        if (token == null) {
            token = getUserCookieToken(request);
            if (token == null) {
                token = tempToken;
            }
        }

        String adminUsername = JwtUtil.getUsername(token);

        String stringBuilder = "菜单:" + Arrays.toString(operationLog.menu()) +
                " 操作:" + operationLog.action() +
                " ip:" + IpUtil.getIpAddr(request) +
                " 用户名:" + adminUsername +
                " 操作时间:" + localDateTime +
                " 结果:" + commonResult.getMessage();
        log.info(stringBuilder);

        operationLogVo.setAdminUserName(adminUsername);
        operationLogVo.setIp(IpUtil.getIpAddr(request));
        operationLogVo.setAction(operationLog.action());
        operationLogVo.setResult(commonResult.getMessage());
        operationLogVo.setMenu(Arrays.toString(operationLog.menu()));
        adminOperationLogMapper.insert(operationLogVo);


    }

    private String getUserCookieToken(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length == 0) {
            return null;
        }
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if (name.equals("Record-Admin-Token")) {
                return cookie.getValue();
            }
        }
        return null;
    }

}
