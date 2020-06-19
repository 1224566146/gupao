package com.fan.gupao.demo.simple;

/**
 * @author 樊高风
 * @date 2020/6/19 20:18
 */
public class SimpleTest {


    public static void resize(Rectangle rectangle){
        while (rectangle.getWidth() >= rectangle.getHeight()){
            rectangle.setHeight(rectangle.getHeight()+1);
            System.out.println("Width:"+rectangle.getWidth()+",Height:"+rectangle.getHeight());
        }
        System.out.println("Resize End,Width:"+rectangle.getWidth()+",Height:"+rectangle.getHeight());
    }


//    public static void main(String[] args) {
//        Rectangle rectangle = new Rectangle();
//        rectangle.setHeight(10);
//        rectangle.setWidth(20);
//        resize(rectangle);
//    }

    public static void main(String[] args) {
        Square square = new Square();
        square.setLength(10);
        resize(square);
    }

}
