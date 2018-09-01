package com.netty4.server.conf.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.netty4.server.entity.SysUser;
import com.netty4.server.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class JwtHelper {


    private static final Logger LOGGER = LoggerFactory.getLogger(JwtHelper.class);

    public static final Gson GSON = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public static final JsonParser JSON_PARSER = new JsonParser();

    public static final String CLAIM_USERID = "userId";
    public static final String CLAIM_USER = "userInfo";


    /**
     * 解析jwt
     */
    public static DecodedJWT parseJWT(String jsonWebToken, JwtProperties jwtProperties) {
        try {
            jsonWebToken = unGzip(jsonWebToken);
            Algorithm signatureAlgorithm = Algorithm.HMAC256(jwtProperties.getSecret());
            JWTVerifier verifier = JWT.require(signatureAlgorithm)
                    .withIssuer(jwtProperties.getIssuser())
                    .withAudience(jwtProperties.getAudience())
                    .build();
            return verifier.verify(jsonWebToken);
        } catch (Exception ex) {
            LOGGER.error("解析jwt 异常 token:{},{}", ex.getMessage(), jsonWebToken);
            return null;
        }
    }

    /**
     * 构建jwt
     */
    public static String createJWT(SysUser user,
                                   JwtProperties jwtProperties) {
        Algorithm signatureAlgorithm = Algorithm.HMAC256(jwtProperties.getSecret());
        Date now = new Date();
        Map<String, Object> userInfo = new HashMap<>(9);
//        userInfo.put("employeeName",user.getEmployee().getName());
        userInfo.put(CLAIM_USERID, user.getId());
        String userInfoStr = GSON.toJson(userInfo, new TypeToken<Map<String, Object>>() {
        }.getType());
        userInfoStr = CommonUtil.urlEncoder(userInfoStr);
        JWTCreator.Builder builder = JWT.create().withIssuer(jwtProperties.getIssuser())
                .withClaim(CLAIM_USER, userInfoStr)
                .withAudience(jwtProperties.getAudience());
        //添加Token过期时间
        if (jwtProperties.getExpiresSecond() >= 0) {
            long expMillis = now.getTime() + (jwtProperties.getExpiresSecond() * 1000);
            Date exp = new Date(expMillis);
            builder.withExpiresAt(exp).withNotBefore(now);
        }
        //生成JWT
        String jwt = builder.sign(signatureAlgorithm);
        jwt = gzip(jwt);
        LOGGER.debug("生成 JWT ;{}", jwt);
        return jwt;
    }


    public static String gzip(String jwt) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = null;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(jwt.getBytes("UTF-8"));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (gzip != null) {
                try {
                    gzip.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return Base64.getEncoder().encodeToString(out.toByteArray());
    }

    public static String unGzip(String compressedStr) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = null;
        GZIPInputStream ginzip = null;
        byte[] compressed = null;
        String decompressed = null;
        try {
            compressed = Base64.getDecoder().decode(compressedStr);
            in = new ByteArrayInputStream(compressed);
            ginzip = new GZIPInputStream(in);


            byte[] buffer = new byte[1024];
            int offset = -1;
            while ((offset = ginzip.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            decompressed = out.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ginzip != null) {
                try {
                    ginzip.close();
                } catch (IOException e) {
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }

        return decompressed;

    }
}
