package com.fan.gupao.pattern.proxy.staticproxy;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:28 2020/3/2
 */
public class FatherProxyTest {

    public static void main(String[] args) {

        Father father = new Father(new Son());
        father.findLove();

        father.findJob();

        //农村，媒婆
        //婚介所


        //大家每天都在用的一种静态代理的形式
        //对数据库分库分表
        //ThreadLocal
        //进行数据源动态切换


    }
}
