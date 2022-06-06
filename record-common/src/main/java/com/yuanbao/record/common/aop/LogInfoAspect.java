package com.yuanbao.record.common.aop;

import com.yuanbao.record.common.CommonResult;
import com.yuanbao.record.common.annotation.OperationLog;
import com.yuanbao.record.common.util.IpUtil;
import com.yuanbao.record.mbp.vo.AdminOperationLogVo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Objects;

@Aspect
@Component
@Slf4j
public class LogInfoAspect {

    //    @Pointcut("execution(public * com.yuanbao.record.admin.controller.*.*(..))")
    @Pointcut("@annotation(com.yuanbao.record.common.annotation.OperationLog)")
    public void loginInfo() {
    }

    @AfterReturning(returning = "commonResult", pointcut = "loginInfo()&&@annotation(operationLog)")
    public void doAfterReturning(CommonResult<?> commonResult, OperationLog operationLog) {
        AdminOperationLogVo operationLogVo = new AdminOperationLogVo();

        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();


        String stringBuilder = "菜单:" + Arrays.toString(operationLog.menu()) +
                " 操作:" + operationLog.action() +
                " ip:" + IpUtil.getIpAddr(request) +
                " 用户名:" + operationLogVo.getAdminUserName() +
                " 操作时间:" + operationLogVo.getCreatedAt() +
                " 结果:" + commonResult.getMessage();
        log.info(stringBuilder);
//        log.info(String.valueOf(request.getSession().getAttribute("Record-Admin-Token")));
    }

}
