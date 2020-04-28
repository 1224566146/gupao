package com.fan.gupao.spring.framework.aop.aspect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 20:37 2020/4/27
 */
public abstract class GPAbstractAspectJAdvice implements GPAdvice {

    private Object aspect;

    private Method adviceMethod;

    private String throwName;

    public GPAbstractAspectJAdvice(Object aspect, Method adviceMethod) {
        this.aspect = aspect;
        this.adviceMethod = adviceMethod;
    }

    protected Object invokeAdviceMethod(GPJoinPoint jp, Object returnValue, Throwable t) throws InvocationTargetException, IllegalAccessException {

        //LogAspect.before(),LogAspect.after()

        Class<?>[] parameterTypes = this.adviceMethod.getParameterTypes();
        if(null == parameterTypes || parameterTypes.length == 0){
            return this.adviceMethod.invoke(this.aspect);
        }else{

            Object[] args = new Object[parameterTypes.length];
            for (int i = 0; i<parameterTypes.length; i++){

                if(parameterTypes[i] == GPJoinPoint.class){
                    args[i] = jp;
                }else if(parameterTypes[i] == Throwable.class){
                    args[i] = t;
                }else if(parameterTypes[i] == Object.class){
                    args[i] = returnValue;
                }

            }

            return this.adviceMethod.invoke(aspect, args);

        }

    }
}
