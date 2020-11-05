package com.gupaoedu.mall.util;

import java.io.Serializable;

/**
 * 响应结果
 */
public class RespResult<T> implements Serializable {

    private static final long serialVersionUID = -6849761032555874274L;

    // 状态码
    private int code;

    // 响应信息
    private String message;

    // 响应数据结果集
    private T data;

    public RespResult() {
    }

    public RespResult(RespCode resultCode){
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public RespResult(T data,RespCode resultCode){
        this.data = data;
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public static RespResult ok(){
        return new RespResult(null,RespCode.SUCCESS);
    }

    public static RespResult ok(Object data){
        return new RespResult(data,RespCode.SUCCESS);
    }

    public static RespResult error(){
        return new RespResult(null,RespCode.ERROR);
    }

    public static RespResult error(String message){
        return secByError(RespCode.ERROR.getCode(),message);
    }

    /**
     * 功能描述:自定义异常
     * @param code 状态码
     * @param message 异常信息
     * @return RespResult
     */
    public static RespResult secByError(int code,String message){
        RespResult err = new RespResult();
        err.setCode(code);
        err.setMessage(message);
        return err;
    }


    public static RespResult error(RespCode resultCode){
        return new RespResult(resultCode);
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
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
