package com.fan.gupao.pattern.adapter.loginadapter.v2;

import com.fan.gupao.pattern.adapter.loginadapter.ResultMsg;

/**
 * @Description:  只扩展
 * @Author: 樊高风
 * @Date: 20:24 2020/3/6
 */
public interface IPassportForThird {

    /**
     * 功能描述:QQ登录
     * @authorer: 樊高风
     * @date: 2020/3/6 20:25
     * @param:
     * @return:
     */
    ResultMsg loginForQQ(String id);


    //微信登录
    ResultMsg loginForWechat(String id);

    //记住登录状态后自动登录
    ResultMsg loginForToken(String token);

    //手机号登录
    ResultMsg loginForTelphone(String telphone,String code);

    //注册后自动登录
    ResultMsg loginForRegist(String userName,String password);

}
