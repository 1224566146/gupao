package com.fan.gupao.pattern.adapter.loginadapter.v2.adapters;

import com.fan.gupao.pattern.adapter.loginadapter.ResultMsg;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 20:54 2020/3/6
 */
public interface RegistAdapter {

    boolean support(Object adapter);

    ResultMsg login(String id,Object adapter);

}
