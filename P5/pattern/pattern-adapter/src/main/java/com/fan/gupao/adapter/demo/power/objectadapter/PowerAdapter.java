package com.fan.gupao.adapter.demo.power.objectadapter;

/**
 * @author 樊高风
 * @date 2020/6/30
 */
public class PowerAdapter implements DC5 {

    private AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int output5V() {
        int adapterInput = ac220.outputAC220V();
        int adapterOutput = adapterInput / 44;
        System.out.println("使用Adapter输入AC"+adapterInput+"V,输出DC"+adapterOutput+"V");
        return adapterOutput;
    }
}
