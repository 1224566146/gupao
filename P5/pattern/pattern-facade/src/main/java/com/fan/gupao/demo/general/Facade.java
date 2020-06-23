package com.fan.gupao.demo.general;

/**
 * @author 樊高风
 * @date 2020/6/23 16:25
 */
// 门面角色 Facade
public class Facade {

    private SubSystemA a = new SubSystemA();
    private SubSystemB b = new SubSystemB();
    private SubSystemC c = new SubSystemC();

    // 对外接口
    public void doA(){
        this.a.doA();
    }

    public void doB(){
        this.b.doB();
    }

    public void doC(){
        this.c.doC();
    }
}
