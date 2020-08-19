package com.fan.gupao.demo.filter;

import com.fan.gupao.demo.bean.User;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author 樊高风
 * @date 2020/8/19
 */
public class RememberMeFormAuthenticationFilter extends FormAuthenticationFilter {


    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {

        Subject subject = getSubject(request, response);
        Session session = subject.getSession();
        if(!subject.isAuthenticated() && subject.isRemembered()
        && session.getAttribute("LOGIN_MSG") == null){
            System.out.println("记住我的帐号:"+((User)subject.getPrincipal()).getName());
            session.setAttribute("LOGIN_MSG", "rememberMe....");
            return true;
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }
}
