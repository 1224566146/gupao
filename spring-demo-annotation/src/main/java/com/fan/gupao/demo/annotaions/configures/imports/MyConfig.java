package com.fan.gupao.demo.annotaions.configures.imports;

import com.fan.gupao.project.entity.Cat;
import com.fan.gupao.project.entity.Company;
import com.fan.gupao.project.entity.Member;
import com.fan.gupao.project.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:57 2020/4/14
 */
@Configuration
@Import(value = {MyImportSelector.class, Cat.class,MyImportBeanDefinitionRegistrar.class})
public class MyConfig {

    @Bean
    public Company company(){
        return new Company();
    }

    @Bean
    public Member member(){
        return new Member();
    }


    // 给IOC中注册Bean的方式
    // 1、@Bean直接导入单个类
    // 2、@ComponentScan包扫描默认是扫描(@Controller、@Service、@Respository、@Component)
    // 3、@Import快速给容器导入组件Bean
    //    a、@Import直接传参导入
    //    b、ImportSelector 自定义导入规则
    //    c、ImportBeanDefinitionRegistrar，使用BeanDefinitionRegistry可以手动注入到IOC容器中
    // 4、FactoryBean 把需要注入的对象封装为FactoryBean
    //    a、FactoryBean负责将Bean注入到容器的Bean
    //    b、BeanFactory从IOC中获得Bean对象
    @Bean
    public Person person(){
        return new Person("Tom",18);
    }

    @Bean
    public MyFactoryBean monkey(){
        return new MyFactoryBean();
    }

}
