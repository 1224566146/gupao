package com.fan.gupao.demo;

/**
 * @author 樊高风
 * @Title: VolatileSyncDemo
 * @ProjectName p5-practice
 * @Description: VolatileSyncDemo
 * @date 2020/6/6 14:51
 */
public class VolatileSyncDemo {

    private VolatileSyncDemo(){}

    private volatile static VolatileSyncDemo instance = null;

    // DCL问题
    public static VolatileSyncDemo getInstance(){
        if(instance == null){
            synchronized (VolatileSyncDemo.class){
                if(instance == null){
                    instance = new VolatileSyncDemo();
                }
            }
        }
        return instance;
    }

    /**
     * instance = new VolatileSyncDemo();
     * ->
     * 1. memory=allocate()
     * 2. instance=memory
     * 3. ctorInstance(memory)
     *
     *
     * 1.3.2 (不完整实例）
     */

}
