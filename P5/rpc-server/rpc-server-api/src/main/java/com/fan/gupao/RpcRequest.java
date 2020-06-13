package com.fan.gupao;

import java.io.Serializable;

/**
 * @author 樊高风
 * @date 2020/6/13 15:27
 */
public class RpcRequest implements Serializable {

    private static final long serialVersionUID = -420617965449787758L;
    private String className;

    private String methodName;

    private Object[] paramters;

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

    public Object[] getParamters() {
        return paramters;
    }

    public void setParamters(Object[] paramters) {
        this.paramters = paramters;
    }

    public Class[] getTypes() {
        return types;
    }

    public void setTypes(Class[] types) {
        this.types = types;
    }
}
