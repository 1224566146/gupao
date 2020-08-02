package com.fan.gupao.demo.userserviceprovider.controller.dto;

import com.fan.gupao.demo.exception.ValidException;
import lombok.Data;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.validation.constraints.NotNull;

/**
 * @author 樊高风
 * @date 2020/8/2
 */
@Data
public class AuthLoginDto {

    private String username;

    private String password;

    private String phone;

    private String code;

    private String openId;

    /**
     * @see com.fan.gupao.demo.userserviceprovider.controller.enums.LoginEnum
     */
    @NotNull(message = "登录类型不能为空")
    private Integer loginType;

    public void validData(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuffer stringBuffer = new StringBuffer();
            for (ObjectError allError : bindingResult.getAllErrors()) {
                stringBuffer.append(allError.getDefaultMessage() + '\n');
            }
            throw new ValidException(stringBuffer.toString());
        }
    }

}
