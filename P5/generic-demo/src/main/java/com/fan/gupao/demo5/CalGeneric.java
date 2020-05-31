package com.fan.gupao.demo5;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:36 2020/5/31
 */
public interface CalGeneric<U> {

    U add(U num1, U num2);
    U sub(U num1, U num2);
    U mul(U num1, U num2);
    U div(U num1, U num2);
}
