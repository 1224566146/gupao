package com.fan.gupao.demo;

import com.fan.gupao.demo.dto.OrderDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author 樊高风
 * @date 2020/7/6
 */
public interface OrderService {

    @GetMapping("/orders")
    String orders();

    @PostMapping("/order")
    int insert(OrderDto dto);
}
