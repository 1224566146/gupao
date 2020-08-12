package com.fan.gupao.demo.rpc;

/**
 * @author 樊高风
 * @date 2020/8/12
 */
public class CService implements IService {

    Registy registy;

    CService(){
        registy.regist("cService", this);
    }

    public void c(){
        
    }
}
