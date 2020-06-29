package com.fan.pattern.composite.demo.transparent;

/**
 * @author 樊高风
 * @date 2020/6/29
 */
public class Course extends CourseComponent {

    private String name;

    private double price;

    public Course(String name, double price) {
        this.name = name;
        this.price = price;
    }


    @Override
    public String getName(CourseComponent catalogComponent) {
        return this.name;
    }

    @Override
    public double getPrice(CourseComponent catalogComponent) {
        return this.price;
    }

    @Override
    public void print() {
        System.out.println(name+"(￥"+price+"元)");
    }
}
