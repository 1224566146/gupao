package com.fan.gupao.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;

/**
 * @author 樊高风
 * @date 2020/8/20
 */
@Controller
public class OrderController {


    @RolesAllowed({"ROLE_USER"})
    @RequestMapping("/order/query")
    public String query(){
        return "/order.jsp";
    }


    @RolesAllowed({"ROLE_CREATE"})
    @RequestMapping("/order/create")
    public String create(){
        return "/order.jsp";
    }

}
