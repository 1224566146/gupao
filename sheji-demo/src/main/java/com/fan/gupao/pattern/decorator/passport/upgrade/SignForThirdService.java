package com.fan.gupao.pattern.decorator.passport.upgrade;

import com.fan.gupao.pattern.decorator.passport.old.ISigninService;
import com.fan.gupao.pattern.decorator.passport.old.ResultMsg;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 13:54 2020/3/9
 */
public class SignForThirdService implements ISiginForThirdService {

    private ISigninService signinService;

    public SignForThirdService(ISigninService signinService) {
        this.signinService = signinService;
    }

    @Override
    public ResultMsg loginForQQ(String id) {
        return null;
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        return null;
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return null;
    }

    @Override
    public ResultMsg loginForTelphone(String telphone, String code) {
        return null;
    }

    @Override
    public ResultMsg loginForRegist(String username, String passport) {
        return null;
    }

    @Override
    public ResultMsg regist(String username, String password) {
        return null;
    }

    @Override
    public ResultMsg login(String username, String password) {
        return null;
    }
}
