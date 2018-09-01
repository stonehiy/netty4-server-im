package com.netty4.server.conf.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("jwt")
public class JwtProperties {

    /**
     * 代表这个JWT的接收对象
     */
    private String audience;

    /**
     * 代表这个JWT的签发主体；
     */
    private String issuser;
    /**
     * 进行jwt的签发和jwt的验证
     */
    private String secret;

    /**
     * JWT的过期时间
     */
    private long expiresSecond;

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getIssuser() {
        return issuser;
    }

    public void setIssuser(String issuser) {
        this.issuser = issuser;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getExpiresSecond() {
        return expiresSecond;
    }

    public void setExpiresSecond(long expiresSecond) {
        this.expiresSecond = expiresSecond;
    }
}
