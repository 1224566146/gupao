package com.fan.gupao.adapter.demo.passport.adapterv2.adapters;

import com.fan.gupao.adapter.demo.passport.ResultMsg;

/**
 * @author 樊高风
 * @date 2020/6/30
 */
public interface ILoginAdapter {

    boolean support(Object object);
    ResultMsg login(String id,Object adapter);
}
