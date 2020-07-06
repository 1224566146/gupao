package com.fan.gupao.springcloud.demo.springclouduserservice;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;

/**
 * @author 樊高风
 * @date 2020/7/6
 */
public class MyPing implements IPing {
    @Override
    public boolean isAlive(Server server) {
        System.out.println("isAlive"+server.getHost()+":"+server.getPort());
        return true;
    }
}
