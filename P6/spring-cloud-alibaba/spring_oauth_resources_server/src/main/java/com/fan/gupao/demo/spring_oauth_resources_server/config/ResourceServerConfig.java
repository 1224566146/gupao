package com.fan.gupao.demo.spring_oauth_resources_server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

/**
 * @author 樊高风
 * @date 2020/10/18
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {


    // 访问资源的编号
    public static final String RESOURCE_ID = "res1";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        // 资源编号
        resources.resourceId(RESOURCE_ID)
                // 验证token信息的服务
                .tokenServices(tokenServices())
                .stateless(true);
    }


    /**
     * 功能描述: 远程验证Token信息的服务
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/10/18 22:32
     */
//    @Bean
    public ResourceServerTokenServices tokenServices(){
        RemoteTokenServices services = new RemoteTokenServices();
        // 去Token的授权服务检查token是否合法
        services.setCheckTokenEndpointUrl("http://localhost:9080/oauth/check_token");
        services.setClientId("c1");
        services.setClientSecret("secret");
        return services;
    }


    /**
     * 功能描述: 资源服务的权限
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/10/18 22:34
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").access("#oauth2.hasScope('all')")
                .anyRequest().permitAll()
                .and()
                .csrf().disable()
                // 设置Session为无状态服务 提升效率
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
