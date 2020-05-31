package com.fan.yiji.yijidemo.geli;

import com.netflix.hystrix.*;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 8:46 2020/4/22
 */
public class GetStockServiceCommand extends HystrixCommand<String> {

//    public static void main(String[] args) {
//
//        String dynamicQueueSizeRejectionThreshold = "hystrix.threadpool."+"stock-pool" + ".queueSizeRejectionThreshold";
//        AbstractConfiguration configInstance = ConfigurationManager.getConfigInstance();
//        configInstance.setProperty(dynamicQueueSizeRejectionThreshold, 100);
//
//
//
//    }

    private StockService stockService;

    public GetStockServiceCommand() {
        super(setter());
    }

    private static Setter setter() {
        //服务分组
        HystrixCommandGroupKey groupKey = HystrixCommandGroupKey.Factory.asKey("stock");
        //服务标识
        HystrixCommandKey commandKey = HystrixCommandKey.Factory.asKey("getStock");
        //线程池名称
        HystrixThreadPoolKey threadPoolKey = HystrixThreadPoolKey.Factory.asKey("stock-pool");
        //线程池配置
        HystrixThreadPoolProperties.Setter threadPoolProperties = HystrixThreadPoolProperties.Setter()
                .withCoreSize(10)
                .withKeepAliveTimeMinutes(5)
                .withMaxQueueSize(Integer.MAX_VALUE)
                .withQueueSizeRejectionThreshold(1000);

        //命令属性配置
        HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter()
                .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD);

        return HystrixCommand.Setter
                .withGroupKey(groupKey)
                .andCommandKey(commandKey)
                .andThreadPoolKey(threadPoolKey)
                .andThreadPoolPropertiesDefaults(threadPoolProperties)
                .andCommandPropertiesDefaults(commandProperties);

    }

    public void stockServiceSet(StockService stockService){
        this.stockService = stockService;
    }

    @Override
    protected String run() throws Exception {
        return stockService.getStock();
    }
}
