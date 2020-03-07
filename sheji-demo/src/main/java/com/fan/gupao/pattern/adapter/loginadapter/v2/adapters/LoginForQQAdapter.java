package com.fan.gupao.pattern.adapter.loginadapter.v2.adapters;

import com.fan.gupao.pattern.adapter.loginadapter.ResultMsg;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 20:50 2020/3/6
 */
public class LoginForQQAdapter implements LoginAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForQQAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
