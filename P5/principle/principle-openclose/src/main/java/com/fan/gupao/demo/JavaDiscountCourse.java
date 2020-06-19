package com.fan.gupao.demo;

/**
 * @author 樊高风
 * @date 2020/6/19 18:21
 */
public class JavaDiscountCourse extends JavaCourse {
    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    public Double getDiscountPrice(){
        return super.getPrice() * 0.6;
    }
}
