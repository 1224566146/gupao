package com.fan.gupao.demo3;

import java.util.Date;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:28 2020/5/31
 */
public class Main {

    public static void main(String[] args) {

        // Person实例过程
        Person person = new Person("4124727XXXXXXX");

        // Person2实例过程
        IdentiyCard identiyCard = new IdentiyCard();
        identiyCard.setIdNumber("412727XXXXXXXXXXX");
        identiyCard.setAddress("北京..............");
        identiyCard.setStartDate(new Date());
        identiyCard.setEndData(new Date());

        Person2<String> person2 = new Person2("xxxxxxxx");

        Person2<IdentiyCard> person3 = new Person2<>(identiyCard);
    }

}
