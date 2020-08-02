package com.fan.gupao.demo.userserviceprovider.biz;

import com.fan.gupao.demo.api.R;
import com.fan.gupao.demo.exception.BizException;
import com.fan.gupao.demo.userserviceprovider.controller.dto.AuthLoginDto;

/**
 * @author 樊高风
 * @date 2020/8/2
 */
public interface Login {

    R doLogin(AuthLoginDto authLoginDto) throws BizException;

}
