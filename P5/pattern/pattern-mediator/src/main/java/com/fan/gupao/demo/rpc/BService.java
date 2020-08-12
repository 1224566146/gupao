package com.fan.gupao.demo.rpc;

/**
 * @author 樊高风
 * @date 2020/8/12
 */
public class BService implements IService {

    Registy registy;

    BService(){
        registy.regist("bService", this);
    }

    public void b(){
        
    }
}
