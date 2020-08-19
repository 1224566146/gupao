package com.fan.gupao.demo.filter;

import com.fan.gupao.demo.bean.User;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author 樊高风
 * @date 2020/8/19
 */
public class GpFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        User user = (User) subject.getPrincipal();
        System.out.println("登录的帐号是:"+user.getName());
        Session session = subject.getSession();
        session.setAttribute("LOGIN_MSG", "自定义的FormFilter传递的信息...");
        return super.onLoginSuccess(token, subject, request, response);
    }
}
