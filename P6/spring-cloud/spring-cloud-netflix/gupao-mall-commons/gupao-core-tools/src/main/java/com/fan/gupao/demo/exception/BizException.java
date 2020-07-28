package com.fan.gupao.demo.exception;

/**
 * @author 樊高风
 * @date 2020/7/27
 */
public class BizException extends BaseException {

    public BizException(){
        super();
    }

    public BizException(String message){
        super(message);
        this.msg = message;
    }

    public BizException(String code, String msg){
        super();
        this.msg = msg;
        this.code = code;
    }

}
