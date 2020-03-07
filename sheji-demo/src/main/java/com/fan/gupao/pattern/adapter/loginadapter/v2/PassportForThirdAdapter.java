package com.fan.gupao.pattern.adapter.loginadapter.v2;

import com.fan.gupao.pattern.adapter.loginadapter.ResultMsg;
import com.fan.gupao.pattern.adapter.loginadapter.v1.SignService;
import com.fan.gupao.pattern.adapter.loginadapter.v2.adapters.*;

/**
 * @Description:  结合策略模式、工厂模式、适配器模式
 * @Author: 樊高风
 * @Date: 20:57 2020/3/6
 */
public class PassportForThirdAdapter extends SignService implements IPassportForThird {
    @Override
    public ResultMsg loginForQQ(String id) {
        return processLogin(id, LoginForQQAdapter.class);
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        return processLogin(id, LoginForWechatAdapter.class);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return processLogin(token, LoginForTokenAdapter.class);
    }

    @Override
    public ResultMsg loginForTelphone(String telphone, String code) {
        return processLogin(telphone, LoginForTelAdapter.class);
    }

    @Override
    public ResultMsg loginForRegist(String userName, String password) {
        super.regist(userName, password);
       return super.login(userName, password);
    }

    private ResultMsg processLogin(String key, Class<? extends LoginAdapter> clazz) {

        try {


            //适配器不一定要实现接口
            LoginAdapter loginAdapter = clazz.newInstance();

            //判断传过来的适配器是否能处理指定的逻辑
            if (loginAdapter.support(loginAdapter)) {

                return loginAdapter.login(key, loginAdapter);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }
}
