package com.fan.gupao.demo.userserviceprovider.biz;

import com.fan.gupao.demo.userserviceprovider.controller.dto.AuthLoginDto;
import com.fan.gupao.demo.userserviceprovider.controller.enums.LoginEnum;
import com.fan.gupao.demo.userserviceprovider.mapper.entitys.TbMember;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author 樊高风
 * @date 2020/8/2
 */
@Service
public class PhoneCodeLoginProcessor extends AbstractLogin {
    @Override
    public int getLoginType() {
        return LoginEnum.PHONE_CODE.getCode();
    }

    @Override
    public void validate(AuthLoginDto authLoginDto) {
        if(StringUtils.isBlank(authLoginDto.getPhone())){

        }

    }

    @Override
    public TbMember doProcessor(AuthLoginDto authLoginDto) {
        return null;
    }
}
