package com.fan.gupao.pattern.adapter.loginadapter.v1;

import com.fan.gupao.pattern.adapter.loginadapter.ResultMsg;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 20:18 2020/3/6
 */
public class SinginForThirdService extends SignService {

    public ResultMsg loginForQQ(String openId){
        //1、openId是全局唯一，我们可以把它当做是一个用户名（加长）
        //2、密码默认为QQ_EMPTY
        //3、注册（在原有系统里面创建一个用户）

        //4、调用原来的登录方法
        return login(openId, null);
    }


    public ResultMsg loginForWechat(String openId){
        return null;
    }


    public ResultMsg loginForToken(String token){
        //通过token拿到用户信息，然后在重新登录一次
        return null;
    }


    public ResultMsg loginForTelphone(String telphone,String code){
        return null;
    }


    public ResultMsg loginForRegist(String userName,String password){
        super.regist(userName, password);
        return super.login(userName, password);
    }


}
