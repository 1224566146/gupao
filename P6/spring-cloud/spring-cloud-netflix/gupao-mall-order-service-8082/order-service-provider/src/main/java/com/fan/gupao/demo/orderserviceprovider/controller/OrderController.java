package com.fan.gupao.demo.orderserviceprovider.controller;

import com.fan.gupao.demo.api.R;
import com.fan.gupao.demo.orderserviceprovider.controller.dto.OrderDto;
import com.fan.gupao.demo.orderserviceprovider.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 樊高风
 * @date 2020/7/27
 */
@RestController
public class OrderController {

    @Autowired
    IOrderService orderService;

    @PostMapping("/order")
    public R order(@RequestBody @Validated OrderDto orderDto, BindingResult bindingResult){
        orderDto.validData(bindingResult);
        String orderId = orderService.createOrder(orderDto);
        return new R.Builder<>().setData(orderId).buildOk();
    }

}
