package com.gupaoedu.mall.util;

/**
 * 响应码
 */
public enum RespCode {

    /**
     * 成功
     */
    SUCCESS(0,"操作成功"),
    /**
     * 失败
     */
    ERROR(50000,"操作失败"),

    /**
     * 系统错误
     */
    SYSTEM_ERROR(50001,"系统错误")
    ;


    private int code;

    private String message;

    RespCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }}
