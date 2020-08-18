package com.fan.gupao.demo.controller;

import com.fan.gupao.demo.service.IUserService;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 樊高风
 * @date 2020/8/18
 */
@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/user/query")
    public String query(@RequestParam(required = false) String userName){
        return userService.query(userName).toString();
    }

    /**
     * 功能描述: 在认证失败后执行的方法,在此方法中我们可以获取认证的相关信息,并跳转到对应的页面
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/8/18 17:26
     */
    @RequestMapping("/login.do")
    public String login(Model model, HttpServletRequest request){
        Object attribute = request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        if(attribute != null){
            System.out.println(attribute.toString()+"-----------");
        }
        return "/login.jsp";
    }
}
