package com.fan.gupao.demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author 樊高风
 * @Title: DataImportThread
 * @ProjectName p5-practice
 * @Description: DataImportThread
 * @date 2020/6/6 16:04
 */
public class DataImportThread extends Thread {

    private String path;

    private CyclicBarrier cyclicBarrier;

    public DataImportThread(String path, CyclicBarrier cyclicBarrier) {
        this.path = path;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("开始导入:"+path+"位置的数据");
        try {
            cyclicBarrier.await(); // 阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        super.run();
    }

}
