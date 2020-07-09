package com.fan.gupao.demo.orderservice;

import com.fan.gupao.demo.OrderService;
import com.fan.gupao.demo.dto.OrderDto;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 樊高风
 * @date 2020/7/6
 */
@RestController
public class OrderServiceImpl implements OrderService {
    @Override
    public String orders() {
        return "Return All Orders";
    }

    @Override
    public int insert(OrderDto dto) {
        return 0;
    }
}
