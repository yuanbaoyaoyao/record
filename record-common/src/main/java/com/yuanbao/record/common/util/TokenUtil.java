//package com.yuanbao.record.common.api.util;
//
//import org.apache.commons.lang.StringUtils;
//
//import javax.servlet.http.HttpServletRequest;
//
//public class TokenUtil {
//
//    public static String getRequestToken(HttpServletRequest httpServletRequest) {
//        String token = httpServletRequest.getHeader("token");
//
//        if (StringUtils.isBlank(token)) {
//            token = httpServletRequest.getParameter("token");
//        }
//        return token;
//    }
//}
