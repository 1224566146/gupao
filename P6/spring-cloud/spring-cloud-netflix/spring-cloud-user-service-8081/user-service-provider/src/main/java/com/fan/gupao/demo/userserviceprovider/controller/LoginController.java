package com.fan.gupao.demo.userserviceprovider.controller;

import com.fan.gupao.demo.api.R;
import com.fan.gupao.demo.exception.BizException;
import com.fan.gupao.demo.userserviceprovider.biz.AbstractLogin;
import com.fan.gupao.demo.userserviceprovider.biz.Login;
import com.fan.gupao.demo.userserviceprovider.controller.dto.AuthLoginDto;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 樊高风
 * @date 2020/8/2
 */
@RestController
public class LoginController {

    @PostMapping("/login")
    public R loginAuth(@RequestBody @Validated AuthLoginDto authLoginDto, BindingResult bindingResult){
        authLoginDto.validData(bindingResult);
        // 登录逻辑
        Login login = AbstractLogin.loginMap.get(authLoginDto.getLoginType());
        if(login == null){
            throw new BizException("暂不支持该种登录类型");
        }
        return login.doLogin(authLoginDto);
    }

}
