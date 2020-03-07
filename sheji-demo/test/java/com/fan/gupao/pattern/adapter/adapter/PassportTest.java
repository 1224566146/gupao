package com.fan.gupao.pattern.adapter.adapter;

import com.fan.gupao.pattern.adapter.loginadapter.v2.IPassportForThird;
import com.fan.gupao.pattern.adapter.loginadapter.v2.PassportForThirdAdapter;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 21:06 2020/3/6
 */
public class PassportTest {

    public static void main(String[] args) {


        IPassportForThird ipassportForThird = new PassportForThirdAdapter();
        ipassportForThird.loginForQQ("");


    }
}
