package com.fan.gupao.demo;

/**
 * @author 樊高风
 * @date 2020/6/18 13:32
 */
@GpRemoteService
public class TestServiceImpl implements ITestService {
    @Override
    public String sayHello() {
        return "execute sayHello Method";
    }
}
