package com.fan.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 20:43 2020/5/25
 */
@ConfigurationProperties(prefix = "gp.redisson")
public class RedissonProperties {
    private String host = "localhost";
    private String password;
    private int port = 6379;
    private int timeout;
    private boolean ssl;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public boolean isSsl() {
        return ssl;
    }

    public void setSsl(boolean ssl) {
        this.ssl = ssl;
    }
}
