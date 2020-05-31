package com.fan.gupao.pattern.prototype.deep;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 11:16 2020/2/19
 */
public class DeepCloneTest {

    public static void main(String[] args) {

        QiTian qiTian = new QiTian();

        try {
            QiTian clone =(QiTian)qiTian.clone();

            System.out.println("深克隆:"+(qiTian.jinGuBang == clone.jinGuBang));

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


        QiTian qiTian1 = new QiTian();
        QiTian clone1 =(QiTian) qiTian1.shallowClone(qiTian1);
        System.out.println("浅克隆:"+(qiTian1.jinGuBang == clone1.jinGuBang));


    }
}
