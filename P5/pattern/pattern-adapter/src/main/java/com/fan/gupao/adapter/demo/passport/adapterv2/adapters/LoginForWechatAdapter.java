package com.fan.gupao.adapter.demo.passport.adapterv2.adapters;

import com.fan.gupao.adapter.demo.passport.ResultMsg;

/**
 * @author 樊高风
 * @date 2020/6/30
 */
public class LoginForWechatAdapter extends AbstraceAdapter {
    @Override
    public boolean support(Object object) {
        return object instanceof LoginForWechatAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        if(!support(adapter)){
            return null;
        }
        return super.loginForRegist(id, null);
    }
}
