package com.fan.gupao.demo.general;

/**
 * @author 樊高风
 * @date 2020/7/30
 */
public class Test {

    public static void main(String[] args) {


        // 来一个容器对象
        IAggregate<String> aggregate = new ConcreteAggregate<>();
        // 添加元素
        aggregate.add("one");
        aggregate.add("two");
        aggregate.add("three");
        aggregate.add("four");

        // 获取迭代器对象
        Iterator<String> iterator = aggregate.iterator();
        // 遍历
        while (iterator.hasNext()){
            String element = iterator.next();
            System.out.println(element);
        }

    }
}
