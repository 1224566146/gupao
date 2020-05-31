package com.fan.gupao.pattern.adapter.loginadapter.v2.adapters;

import com.fan.gupao.pattern.adapter.loginadapter.ResultMsg;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 20:52 2020/3/6
 */
public class LoginForTelAdapter implements LoginAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForTelAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
