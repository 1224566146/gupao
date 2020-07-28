package com.fan.gupao.demo.exception;

/**
 * @author 樊高风
 * @date 2020/7/27
 */
public class ValidException extends BaseException {

    public ValidException(){
        super();
    }

    public ValidException(String message){
        super(message);
        this.msg = message;
    }

    public ValidException(String code,String msg){
        super();
        this.msg = msg;
        this.code = code;
    }

}
