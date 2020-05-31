package com.fan.gupao.demo3;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 13:52 2020/5/26
 */
public class Boy extends Person {

    // 身高
    public int height;

    // 体重
    private int weight;

    public static String desc;

    public Boy() {
    }

    private Boy(int height) {
        this.height = height;
    }

    public Boy(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public static void playBasketball(){
        System.out.println("Play basketBall!");
    }

    public void playball(String ballType){
        System.out.println("Play"+ballType+"!");
    }

    private void pickUpGirl(){
        System.out.println("pick up girl!");
    }

    public int getWeight() {
        return weight;
    }
}
