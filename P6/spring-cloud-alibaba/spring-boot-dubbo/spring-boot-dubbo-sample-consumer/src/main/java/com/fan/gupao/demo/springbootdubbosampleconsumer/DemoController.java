package com.fan.gupao.demo.springbootdubbosampleconsumer;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 樊高风
 * @date 2020/8/10
 */
@RestController
public class DemoController {

    @DubboReference(interfaceName = "com.fan.gupao.demo.springbootdubbosampleprovider.services.IDemoService",generic = true,check = false)
    GenericService genericService;


    @GetMapping("/demo")
    public String demo(){
        return genericService.$invoke("getTxt", new String[0], null).toString();
    }

}
