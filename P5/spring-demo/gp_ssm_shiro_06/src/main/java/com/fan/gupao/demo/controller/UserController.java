package com.fan.gupao.demo.controller;

import com.fan.gupao.demo.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 樊高风
 * @date 2020/8/18
 */
@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 功能描述:
     * @RequiresRoles(value={"admin"})
     *  当前请求的用户必须具有admin这个角色才能访问
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/8/19 9:37
     */
    @RequiresRoles(value = {"admin","person"},logical = Logical.OR)
    @RequestMapping("/user/query")
    public String query(@RequestParam(required = false) String userName){
        Session session = SecurityUtils.getSubject().getSession();
        System.out.println("--------->"+session.getAttribute("msg"));
        System.out.println("-----sssss---->"+session.getAttribute("LOGIN_MSG"));
        return "/user.jsp";
    }

    @RequestMapping("/user/create")
    public String create(HttpSession session){
        session.setAttribute("msg", "shiroTest....");
        return "/user.jsp";
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
