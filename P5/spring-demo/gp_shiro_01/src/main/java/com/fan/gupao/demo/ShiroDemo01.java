package com.fan.gupao.demo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * @author 樊高风
 * @date 2020/8/17
 */
public class ShiroDemo01 {

    public static void main(String[] args) {

        // 1、获取一个SecurityManager工厂对象 加载对应的配置文件 将相关的配置信息解析到了Ini对象
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        // 2、通过Factory对象获取SecurityManager对象
        SecurityManager manager = factory.getInstance();
        // 3、将SecurityManager添加到运行时环境中
        SecurityUtils.setSecurityManager(manager);
        // 4、通过SecurityManager获取Subject
        Subject subject = SecurityUtils.getSubject();
        // 假设获取用户提交的帐号密码
        String userName = "zhang";
        String password = "123";
        // 将用户提交的数据封装成一个AuthenticationToken对象
        AuthenticationToken token = new UsernamePasswordToken(userName, password);
        // 认证
        try {
            subject.login(token);
            System.out.println("认证成功....");
        }catch (UnknownAccountException e){
            System.out.println("帐号不存在");
        }catch (IncorrectCredentialsException e){
            System.out.println("密码错误");
        }catch (Exception e){
            System.out.println("其他错误");
        }
    }
}
