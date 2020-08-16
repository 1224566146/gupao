package com.fan.gupao.demo;

import com.fan.gupao.demo.bean.User;
import com.fan.gupao.demo.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        // 获取Ioc容器对象,通过Service对象查询相关的数据
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserService service = context.getBean(IUserService.class);
        List<User> users = service.queryList();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
