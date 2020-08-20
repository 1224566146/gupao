package com.fan.gupao.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 樊高风
 * @date 2020/8/20
 */
@Controller
public class RoleController {


    @PreAuthorize(value = "hasAnyRole('ROLE_USER')")
    @RequestMapping("/role/query")
    public String query(){
        return "/role.jsp";
    }


    @PreAuthorize(value = "hasAnyRole('ROLE_CREATE')")
    @RequestMapping("/role/create")
    public String create(){
        return "/role.jsp";
    }

}
