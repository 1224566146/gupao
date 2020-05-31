package com.fan.gupao.pattern.decorator.passport;

import com.fan.gupao.pattern.decorator.passport.old.SigninService;
import com.fan.gupao.pattern.decorator.passport.upgrade.ISiginForThirdService;
import com.fan.gupao.pattern.decorator.passport.upgrade.SignForThirdService;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 13:56 2020/3/9
 */
public class DecoratorTest {

    public static void main(String[] args) {

        //满足一个is-a
        ISiginForThirdService iSiginForThirdService = new SignForThirdService(new SigninService());
        iSiginForThirdService.loginForQQ("sdfdsfsd");


    }
}
