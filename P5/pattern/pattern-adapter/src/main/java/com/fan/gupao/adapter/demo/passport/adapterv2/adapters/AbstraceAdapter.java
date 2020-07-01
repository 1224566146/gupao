package com.fan.gupao.adapter.demo.passport.adapterv2.adapters;

import com.fan.gupao.adapter.demo.passport.PassportService;
import com.fan.gupao.adapter.demo.passport.ResultMsg;

/**
 * @author 樊高风
 * @date 2020/6/30
 */
public abstract class AbstraceAdapter extends PassportService implements ILoginAdapter {

    protected ResultMsg loginForRegist(String username,String password){
        if(null == password){
            password = "THIRD_EMPTY";
        }
        super.regist(username, password);
        return super.login(username, password);
    }

}
