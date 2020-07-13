package com.fan.gupao.demo;

import com.fan.gupao.demo.dto.OrderDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
public interface OrderService {

    @GetMapping("/orders")
    String orders();

    @PostMapping("/order")
    int insert(OrderDto dto);
}
