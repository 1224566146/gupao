package com.fan.gupao.demo.orderserviceprovider.controller.dto;

import com.fan.gupao.demo.exception.ValidException;
import lombok.Data;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author 樊高风
 * @date 2020/7/27
 */
@Data
public class OrderDto {

    @NotNull(message = "name不能为空")
    private String name;
    @NotNull(message = "tel不能为空")
    private String tel;
    private String userId;

    @NotEmpty(message = "商品列表为空")
    private List<ItemsDto> items;

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
