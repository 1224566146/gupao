package com.fan.gupao.demo1;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:08 2020/5/31
 */
public class GenericDemo1 {

    public static void main(String[] args) throws Exception {

//        method(100, "张三");
//        Demo1();
//        demo2();
//        demo3();
//        demo4();

        // demo5
//        ArrayList<String> arrayList1 = new ArrayList<>();
//        ArrayList<Number> arrayList2 = new ArrayList<>();
//        demo5(arrayList1);
//        demo5(arrayList2);

        // demo6
        ArrayList<Integer> arrayList3 = new ArrayList<Integer>();
        ArrayList<Number> arrayList4 = new ArrayList<Number>();
        ArrayList<Double> arrayList5 = new ArrayList<Double>();
        ArrayList<String> arrayList55 = new ArrayList<String>();
        demo6(arrayList3);
        demo6(arrayList4);
//        demo6(arrayList55);

        // demo7
        ArrayList<Integer> arrayList6 = new ArrayList<Integer>();
        ArrayList<Number> arrayList7 = new ArrayList<Number>();
        ArrayList<Double> arrayList8 = new ArrayList<Double>();
        demo7(arrayList6);
        demo7(arrayList7);
//        demo7(arrayList8);

    }


    public static void method(int count, String str) {
        System.out.println("count:" + count);
        System.out.println("str:" + str);
    }

    public static void demo1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(38);
        arrayList.add("zhangsan");
        arrayList.add(new Object());

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i).getClass());
        }
    }

    /**
     * 功能描述：限定类型的集合使用
     *
     * @authorer: 樊高风
     * @date: 2020/5/31 10:12
     * @param:
     * @return:
     */
    public static void demo2() {
        ArrayList<String> stringArrayList = new ArrayList();
//        stringArrayList.add(38);
        stringArrayList.add("zhangsan");
//        stringArrayList.add(new Object());

        for (int i = 0; i < stringArrayList.size(); i++) {
            System.out.println(stringArrayList.get(i).getClass());
        }
    }

    /**
     * 功能描述：泛型只在编译阶段有效
     * 在编译之后程序会采取去泛型化的措施
     * 正确校验泛型结果后，会将泛型的相关信息擦出
     *
     * @authorer: 樊高风
     * @date: 2020/5/31 10:14
     * @param:
     * @return:
     */
    public static void demo3() {
        ArrayList arrayList = new ArrayList();
        ArrayList<String> stringArrayList = new ArrayList<>();

        System.out.println(arrayList.getClass());
        System.out.println(stringArrayList.getClass());
        System.out.println(arrayList.getClass() == stringArrayList.getClass());
    }

    public static void demo4() throws Exception {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("zhangsan");
        stringArrayList.add("lisi");
        stringArrayList.add("wangwu");
        System.out.println("操作之前长度:" + stringArrayList.size());

        // 反射进行元素的新增
        Class<? extends ArrayList> clazz = stringArrayList.getClass();
        Method method = clazz.getDeclaredMethod("add", Object.class);
        method.invoke(stringArrayList, 88);

        System.out.println("操作之后长度:" + stringArrayList.size());
    }

    /**
     * 功能描述：无边界通配符
     *
     * @authorer: 樊高风
     * @date: 2020/5/31 10:20
     * @param:
     * @return:
     */
    public static void demo5(ArrayList<?> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }

    /**
     * 功能描述：上界通配符
     *
     * @authorer: 樊高风
     * @date: 2020/5/31 10:22
     * @param:
     * @return:
     */
    public static void demo6(ArrayList<? extends Number> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }

    /**
     * 功能描述：下界通配符
     * @authorer: 樊高风
     * @date: 2020/5/31 10:23
     * @param:
     * @return:
     */
    public static void demo7(ArrayList<? super Integer> arrayList){
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
