package com.fan.gupao.pattern.strategy.pay;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 19:03 2020/3/4
 */
public class MsgResult {

    private int code;

    private Object data;

    private String msg;

    public MsgResult(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return ("支付状态:["+code+"],"+ msg+",交易详情:"+data);
    }
}
