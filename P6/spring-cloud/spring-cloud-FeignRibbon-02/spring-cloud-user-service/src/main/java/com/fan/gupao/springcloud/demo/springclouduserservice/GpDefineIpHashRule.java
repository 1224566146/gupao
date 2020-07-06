package com.fan.gupao.springcloud.demo.springclouduserservice;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @author 樊高风
 * @date 2020/7/6
 */
public class GpDefineIpHashRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }


    public Server choose(ILoadBalancer lb,Object key){
        if(lb == null){
            return null;
        }
        Server server = null;
        while (server == null){
            List<Server> allList = lb.getAllServers();
            System.out.println(allList);
            int index = 0;
            server = allList.get(index);
        }
        return server;
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }


}
