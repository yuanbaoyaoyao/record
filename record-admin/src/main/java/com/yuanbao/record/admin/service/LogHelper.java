package com.yuanbao.record.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogHelper {
    public static final Integer LOG_TYPE_GENERAL = 0;
    public static final Integer LOG_TYPE_AUTH = 1;
    public static final Integer LOG_TYPE_ORDER = 2;
    public static final Integer LOG_TYPE_OTHER = 3;

    @Autowired
    private AdminOperationLogService adminOperationLogService;

    public void logGeneralSucceed(String action) {

    }

//    public void logAdmin(Integer type, String action, Boolean succeed, String result, String comment) {
//        AdminOperationLogVo log = new AdminOperationLogVo();
//
//        //shiro
//
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        if(request!=null){
//            log.setIp(IpUtil.getIpAddr(request));
//        }
//
//        log.setType(type);
//        log.setAction(action);
//        log.setStatus(succeed);
//        log.setResult(result);
//        adminOperationLogService.insert(log);
//    }
}
