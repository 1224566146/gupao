package com.fan.gupao.demo2;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 13:39 2020/5/26
 */
public class Excel implements Office {
    @Override
    public void toPDF() {
        System.out.println("Excel to PDF");
    }
}
