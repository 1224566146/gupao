package com.fan.gupao.pattern.singleton.register;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 19:34 2020/2/16
 */
public class ContainerSingletonTest {
    public static void main(String[] args) {

        try {

            long start = System.currentTimeMillis();

            ConcurrentExecutor.execute(new ConcurrentExecutor.RunHandler() {
                @Override
                public void handler() {
                    try {
                        Object obj =ContainerSingleton.getInstance("com.fan.gupao.pattern.singleton.register.Pojo");
                        System.out.println(System.currentTimeMillis() + ":"+obj);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            },10,6);

            long end = System.currentTimeMillis();
            System.out.println("总耗时："+(end-start)+"ms.");

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
