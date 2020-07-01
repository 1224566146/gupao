package com.fan.gupao.adapter.demo.passport.adapterv1;

import com.fan.gupao.adapter.demo.passport.ResultMsg;

/**
 * @author 樊高风
 * @date 2020/6/30
 */
public interface IPassportForThird {

    ResultMsg loginForQQ(String openId);

    ResultMsg loginForWechat(String openId);

    ResultMsg loginForToken(String token);

    ResultMsg loginForTelphone(String phone,String code);
}
