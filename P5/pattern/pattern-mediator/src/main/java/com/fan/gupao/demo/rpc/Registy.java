package com.fan.gupao.demo.rpc;

/**
 * @author 樊高风
 * @date 2020/8/12
 */
public class Registy {

    // 通过中介者缩短调用链
    // 服务治理
    public boolean regist(String serviceName,IService service){
        return true;
    }

    public IService get(String serviceName){
        return null;
    }

}
