package com.fan.gupao.demo.userserviceprovider.controller.enums;

/**
 * @author 樊高风
 * @date 2020/8/2
 */
public enum LoginEnum {

    NORMAL(0, "帐号密码登录"),
    PHONE_PWD(1, "手机号与密码登录"),
    PHONE_CODE(2, "手机验证码登录"),
    WECHAT(3, "微信授权登录");


    private int code;

    private String memo;

    LoginEnum(int code, String memo) {
        this.code = code;
        this.memo = memo;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }}
