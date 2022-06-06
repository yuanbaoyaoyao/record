package com.yuanbao.record.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.yuanbao.record.common.constant.Constant;
import com.yuanbao.record.mbp.mapper.entity.JwtUser;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class JwtUtil {

    private static final String JWT_TOKEN_SECRET_KEY = "yuanbao";//

    public static String createJwtTokenByUser(JwtUser jwtUser) {

        Date date = new Date(System.currentTimeMillis() + Constant.JWT_EXPIRE);
        Algorithm algorithm = Algorithm.HMAC256(JWT_TOKEN_SECRET_KEY);
        return JWT.create()
                .withClaim("username", jwtUser.getUsername())
                .withClaim("roleId", jwtUser.getRoleId())
                .withExpiresAt(date)
                .sign(algorithm);
        //r-p的映射在服务端运行时做，不放进token中
    }


    public static boolean verifyTokenOfUser(String token) throws TokenExpiredException {//user要从sercurityManager拿，确保用户用的是自己的token
        log.info("verifyTokenOfUser");

        //根据密钥生成JWT效验器
        Algorithm algorithm = Algorithm.HMAC256(JWT_TOKEN_SECRET_KEY);
        JWTVerifier verifier = JWT.require(algorithm)
                .withClaim("username", getUsername(token))//从不加密的消息体中取出username
                .build();
        // 一个是直接从客户端传来的token，一个是根据盐和用户名等信息生成secret后再生成的token
        DecodedJWT jwt = verifier.verify(token);
        return true;
    }

    /**
     * 在token中获取到username信息
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    public static JwtUser recreateUserFromToken(String token) {
        JwtUser jwtUser = new JwtUser();
        DecodedJWT jwt = JWT.decode(token);

        jwtUser.setUsername(jwt.getClaim("username").asString());
        jwtUser.setRoleId(jwt.getClaim("roleId").asLong());
//        user.setRoles(jwt.getClaim("roles").asList(String.class));
        //r-p映射在运行时去取
        return jwtUser;
    }

    /**
     * 判断是否过期
     */
    public static boolean isExpire(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getExpiresAt().getTime() < System.currentTimeMillis();
    }
}
