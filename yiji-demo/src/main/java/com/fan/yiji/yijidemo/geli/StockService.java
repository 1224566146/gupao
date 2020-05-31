package com.fan.yiji.yijidemo.geli;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 8:47 2020/4/22
 */
public class StockService {
    public String getStock() {
        System.out.println("打印getStock"+Thread.currentThread().getId()+"======="+Thread.currentThread().getName());
        return "2";
    }
}
