package com.fan.gupao.demo.exception;

/**
 * @author 樊高风
 * @date 2020/7/27
 */
public class BaseException extends RuntimeException {

    protected String code;

    protected String msg;

    public BaseException() {
        super();
    }

    public BaseException(String message){
        super(message);
        this.msg = message;
    }

    public BaseException(String code,String msg){
        super();
        this.code = code;
        this.msg = msg;
    }
}
