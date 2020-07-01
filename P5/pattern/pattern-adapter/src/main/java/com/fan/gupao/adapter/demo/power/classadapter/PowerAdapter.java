package com.fan.gupao.adapter.demo.power.classadapter;

/**
 * @author 樊高风
 * @date 2020/6/30
 */
public class PowerAdapter extends AC220 implements DC5 {
    @Override
    public int output5V() {
        int adapterInput = super.outputAC220V();
        int adapterOutput = adapterInput / 44;
        System.out.println("使用Adapter输入AC"+adapterInput+"V,输出DC"+adapterOutput+"V");
        return adapterOutput;
    }
}
