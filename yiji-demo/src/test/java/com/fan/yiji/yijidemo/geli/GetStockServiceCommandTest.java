package com.fan.yiji.yijidemo.geli;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Future;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 9:16 2020/4/22
 */
public class GetStockServiceCommandTest {


    @Test
    public void hystrixCreateTest() {
        GetStockServiceCommand command = new GetStockServiceCommand();

//        for (int i = 0; i < 100; i++) {

        StockService stockService1 = new StockService();
        command.stockServiceSet(stockService1);

        //同步调用
//            String execute = command.execute();

        //异步调用
        Future<String> queue = command.queue();
//        }


        //响应式编程
//        Observable<String> observe = command.observe();
//        ((rx.Observable) observe).asObservable().subscribe((result) -> {
//            System.out.println(result);
//        });


        System.out.println("输出主线程" + Thread.currentThread().getName());

    }

}
