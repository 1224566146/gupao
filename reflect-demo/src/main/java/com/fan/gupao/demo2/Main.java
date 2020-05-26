package com.fan.gupao.demo2;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 13:40 2020/5/26
 */
public class Main {


    public static void main(String[] args) {

        String key = "PPT";

        Office office = getInstanceByKey(key);
        office.toPDF();
        Office office1 = getInstanceReflectByKey(key);
        office1.toPDF();


        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {
            Office instanceByKey = getInstanceByKey(key);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("总计花费时间：" + (endTime - startTime));

    }

    /**
     * 功能描述：通过传入key创建不同的对象
     *
     * @authorer: 樊高风
     * @date: 2020/5/26 13:42
     * @param:
     * @return:
     */
    public static Office getInstanceByKey(String key) {
        if ("Word".equals(key)) {
            return new Word();
        }
        if ("Excel".equals(key)) {
            return new Excel();
        }
        if ("PPT".equals(key)) {
            return new PPT();
        }
        return null;
    }


    /**
     * 功能描述：通过反射动态创建
     *
     * @authorer: 樊高风
     * @date: 2020/5/26 13:45
     * @param:
     * @return:
     */
    public static Office getInstanceReflectByKey(String key) {
        String packeageName = "com.fan.gupao.demo2";

        Office office = null;

        try {
            // JNI
            Class<?> clazz = Class.forName(packeageName + "." + key);
            office = (Office) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return office;
    }

}
