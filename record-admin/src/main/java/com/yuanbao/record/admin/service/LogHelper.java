package com.yuanbao.record.admin.service;

import com.yuanbao.record.common.api.util.IpUtil;
import com.yuanbao.record.mbp.vo.AdminOperationLogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
public class LogHelper {
    public static final Integer LOG_TYPE_GENERAL = 0;
    public static final Integer LOG_TYPE_AUTH = 1;
    public static final Integer LOG_TYPE_ORDER = 2;
    public static final Integer LOG_TYPE_OTHER = 3;

    @Autowired
    private AdminOperationLogService adminOperationLogService;

    public void logGeneralSucceed(String action) {
        logAdmin(LOG_TYPE_GENERAL, action, true, "");
    }

    public void logGeneralSucceed(String action, String result) {
        logAdmin(LOG_TYPE_GENERAL, action, true, result);
    }

    public void logGeneralFail(String action, String error) {
        logAdmin(LOG_TYPE_GENERAL, action, false, error);
    }

    public void logAuthSucceed(String action) {
        logAdmin(LOG_TYPE_AUTH, action, true, "");
    }

    public void logAuthSucceed(String action, String result) {
        logAdmin(LOG_TYPE_AUTH, action, true, result);
    }

    public void logAuthFail(String action, String error) {
        logAdmin(LOG_TYPE_AUTH, action, false, error);
    }

    public void logOrderSucceed(String action) {
        logAdmin(LOG_TYPE_ORDER, action, true, "");
    }

    public void logOrderSucceed(String action, String result) {
        logAdmin(LOG_TYPE_ORDER, action, true, result);
    }

    public void logOrderFail(String action, String error) {
        logAdmin(LOG_TYPE_ORDER, action, false, error);
    }

    public void logOtherSucceed(String action) {
        logAdmin(LOG_TYPE_OTHER, action, true, "");
    }

    public void logOtherSucceed(String action, String result) {
        logAdmin(LOG_TYPE_OTHER, action, true, result);
    }


    public void logOtherFail(String action, String error) {
        logAdmin(LOG_TYPE_OTHER, action, false, error);
    }

    public void logAdmin(Integer type, String action, Boolean succeed, String result) {
        AdminOperationLogVo log = new AdminOperationLogVo();

        //shiro

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        if (request != null) {
            log.setIp(IpUtil.getIpAddr(request));
        }

        log.setType(type);
        log.setAction(action);
        log.setStatus(succeed);
        log.setResult(result);
        adminOperationLogService.insert(log);
    }
}
