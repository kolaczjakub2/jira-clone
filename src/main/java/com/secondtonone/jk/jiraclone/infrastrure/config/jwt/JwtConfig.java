//package com.secondtonone.jk.jiraclone.infrastrure.config.jwt;
//
//import com.google.common.net.HttpHeaders;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.stereotype.Component;
//
//@Component
//@ConfigurationProperties(prefix = "application.jwt")
//public class JwtConfig {
//
//    private String key;
//    private String tokenPrefix;
//    private Integer tokenExpirationAfterMinutes;
//
//    public JwtConfig() {
//    }
//
//    public String getKey() {
//        return key;
//    }
//
//    public void setKey(String key) {
//        this.key = key;
//    }
//
//    public String getTokenPrefix() {
//        return tokenPrefix;
//    }
//
//    public void setTokenPrefix(String tokenPrefix) {
//        this.tokenPrefix = tokenPrefix;
//    }
//
//    public Integer getTokenExpirationAfterMinutes() {
//        return tokenExpirationAfterMinutes;
//    }
//
//    public void setTokenExpirationAfterMinutes(Integer tokenExpirationAfterMinutes) {
//        this.tokenExpirationAfterMinutes = tokenExpirationAfterMinutes;
//    }
//
//    public String getAuthorizationHeader() {
//        return HttpHeaders.AUTHORIZATION;
//    }
//
//}
