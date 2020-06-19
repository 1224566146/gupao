package com.fan.gupao.demo;

/**
 * @author 樊高风
 * @date 2020/6/19 20:30
 */
public class IspTest {

    public static void resize(Rectangle rectangle){
        while (rectangle.getWidth() >= rectangle.getHeight()){
            rectangle.setHeight(rectangle.getHeight()+1);
            System.out.println("Width:"+rectangle.getWidth()+",Height:"+rectangle.getHeight());
        }
        System.out.println("Resize End,Width:"+rectangle.getWidth()+",Height:"+rectangle.getHeight());
    }

    //    public static void main(String[] args) {
//        Rectangle rectangle = new Rectangle();
//        rectangle.setWidth(20);
//        rectangle.setHeight(10);
//        resize(rectangle);
//    }

//    public static void main(String[] args) {
//        com.gupaoedu.vip.design.principle.liskovsutiution.simple.Square square = new Square();
//        square.setLength(10);
//        resize(square);
//    }

}
