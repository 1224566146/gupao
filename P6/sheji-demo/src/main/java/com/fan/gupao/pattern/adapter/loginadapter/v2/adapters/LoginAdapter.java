package com.fan.gupao.pattern.adapter.loginadapter.v2.adapters;

import com.fan.gupao.pattern.adapter.loginadapter.ResultMsg;

/**
 * @Description:
 * 在适配器里面，这个接口可有可无，不要跟模版模式混淆
 * 模版模式一定是抽象类，而这里仅仅只是一个接口
 * @Author: 樊高风
 * @Date: 20:30 2020/3/6
 */
public interface LoginAdapter {

    boolean support(Object adapter);

    ResultMsg login(String id,Object adapter);

}
