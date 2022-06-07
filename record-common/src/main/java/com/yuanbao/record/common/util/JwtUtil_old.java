//package com.yuanbao.record.common.api.util;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTDecodeException;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.yuanbao.record.common.api.constant.Constant;
//
//import java.util.Date;
//
//public class JwtUtil_old {
//    public static String createToken(String username, String secret) {
//        Date date = new Date(System.currentTimeMillis() + Constant.JWT_EXPIRE);
//        Algorithm algorithm = Algorithm.HMAC256(secret);
//        return JWT.create()
//                .withClaim("username", username)
//                .withExpiresAt(date)
//                .sign(algorithm);
//    }
//
//    public static boolean verifyToken(String token, String username, String secret) {
//        try {
//            Algorithm algorithm = Algorithm.HMAC256(secret);
//            JWTVerifier verifier = JWT.require(algorithm)
//                    .withClaim("username", username)
//                    .build();
//            DecodedJWT jwt = verifier.verify(token);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public static String getUsername(String token) {
//        try {
//            DecodedJWT jwt = JWT.decode(token);
//            return jwt.getClaim("username").asString();
//        } catch (JWTDecodeException e) {
//            return null;
//        }
//    }
//
//    public static boolean isExpire(String token) {
//        DecodedJWT jwt = JWT.decode(token);
//        return jwt.getExpiresAt().getTime() < System.currentTimeMillis();
//    }
//
//}
