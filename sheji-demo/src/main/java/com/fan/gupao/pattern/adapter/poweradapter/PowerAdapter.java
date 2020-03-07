package com.fan.gupao.pattern.adapter.poweradapter;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 20:09 2020/3/6
 */
public class PowerAdapter implements DC5 {


    private AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int outputDC5V() {

        int input = ac220.outputAC220V();
        int adapteroutput = input /44;

        System.out.println("使用PowerAdapter输入AC："+input +"V,输出DC:"+adapteroutput+"V");
        return adapteroutput;
    }
}
