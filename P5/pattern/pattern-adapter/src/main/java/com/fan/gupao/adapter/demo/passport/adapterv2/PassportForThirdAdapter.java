package com.fan.gupao.adapter.demo.passport.adapterv2;

import com.fan.gupao.adapter.demo.passport.ResultMsg;
import com.fan.gupao.adapter.demo.passport.adapterv2.adapters.*;

/**
 * @author 樊高风
 * @date 2020/6/30
 */
public class PassportForThirdAdapter implements IPassportForThird {
    @Override
    public ResultMsg loginForQQ(String openId) {
        return processLogin(openId, LoginForQQAdapter.class);
    }

    @Override
    public ResultMsg loginForWechat(String openId) {
        return processLogin(openId, LoginForWechatAdapter.class);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return processLogin(token, LoginForTokenAdapter.class);

    }

    @Override
    public ResultMsg loginForTelphone(String phone, String code) {
        return processLogin(phone, LoginForTelAdapter.class);

    }

    private ResultMsg processLogin(String id, Class<? extends ILoginAdapter> clazz){
        try {
            ILoginAdapter adapter = clazz.newInstance();
            if(adapter.support(adapter)){
                return adapter.login(id, adapter);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
