package com.fan.gupao.demo;

/**
 * @author 樊高风
 * @Title: ThreadDemo
 * @ProjectName p5-practice
 * @Description: 线程demo
 * @date 2020/6/6 13:40
 */
public class ThreadDemo extends Thread{

    @Override
    public void run() {
        System.out.println("当前线程:"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start(); // 启动一个线程
    }
}
