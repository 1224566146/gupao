package com.fan.gupao.demo.springbootnacosdemo;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 樊高风
 * @date 2020/8/27
 */
@RestController
public class ServiceController {


    @NacosInjected
    private NamingService namingService;


    @GetMapping("/discovery")
    public List<Instance> get(@RequestParam String serviceName) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }


    @PostMapping("/registry")
    public void registry() throws NacosException{
        namingService.registerInstance("example", "192.168.1.1", 8888 ,"Test");
    }



}
