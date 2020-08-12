package com.fan.gupao.demo.rpc;

/**
 * @author 樊高风
 * @date 2020/8/12
 */
public class AService implements IService {

    Registy registy;

    AService(){
        registy.regist("aService", this);
    }

    public void a(){

    }
}
