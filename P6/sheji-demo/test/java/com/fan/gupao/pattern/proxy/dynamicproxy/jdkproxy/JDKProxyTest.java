package com.fan.gupao.pattern.proxy.dynamicproxy.jdkproxy;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 16:11 2020/3/2
 */
public class JDKProxyTest {
    public static void main(String[] args) {

        try {
            //1、第一种
//            Person obj = (Person) new JDKMeipo().getInstance(new Girl());
//            obj.findLove();

            //2、第二种
            Object obj = new JDKMeipo().getInstance(new Girl());
            Method method = obj.getClass().getMethod("findLove", null);
            method.invoke(obj, null);

//            byte[] by = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
//            FileOutputStream fos = new FileOutputStream("F://$Proxy0.class");
//            fos.write(by);
//            fos.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
