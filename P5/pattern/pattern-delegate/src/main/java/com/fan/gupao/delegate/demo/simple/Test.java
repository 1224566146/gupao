package com.fan.gupao.delegate.demo.simple;

/**
 * @author 樊高风
 * @date 2020/7/4
 */
public class Test {

    public static void main(String[] args) {

        new Boss().command("海报图", new Leader());
        new Boss().command("爬虫", new Leader());
        new Boss().command("买手机", new Leader());

    }
}
