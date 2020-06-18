package com.fan.gupao.demo;

import java.io.Serializable;

/**
 * @author 樊高风
 * @date 2020/6/18 9:20
 */
public class RpcRequest implements Serializable {


    private static final long serialVersionUID = 5028137386561370221L;
    private String className;

    private String methodName;

    private Object[] args;

    private Class[] types;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public Class[] getTypes() {
        return types;
    }

    public void setTypes(Class[] types) {
        this.types = types;
    }
}
