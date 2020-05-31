package com.fan.gupao.pattern.proxy.dynamicproxy.gpproxy;

import com.fan.gupao.pattern.proxy.Person;
import com.fan.gupao.pattern.proxy.dynamicproxy.jdkproxy.Girl;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 19:02 2020/3/2
 */
public class GPProxyTest {

    public static void main(String[] args) {


        try {
            Person obj =(Person) new GPMeipo().getInstance(new Girl());

            System.out.println(obj.getClass());
            obj.findLove();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
