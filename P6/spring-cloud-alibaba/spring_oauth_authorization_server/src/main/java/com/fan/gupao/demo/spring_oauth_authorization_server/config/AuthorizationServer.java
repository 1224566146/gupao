package com.fan.gupao.demo.spring_oauth_authorization_server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @author 樊高风
 * @date 2020/10/18
 */
@Configuration
// 激活OAuth2.0显示的表示是一个授权服务
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private AuthorizationCodeServices authorizationCodeServices;


    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 功能描述: 配置客户端信息
     *
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/10/18 16:40
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 使用内存来存储客户端的信息
        clients.inMemory()
                // 客户端编号
                .withClient("c1")
                .secret(new BCryptPasswordEncoder().encode("secret"))
                // 可以访问的资源的编号
                .resourceIds("res1")
                // 改客户端允许的授权类型
                .authorizedGrantTypes("authorization_code", "password", "client_credentials", "implicit", "refresh_token")
                // 允许的范围 我们对资源操作的作用域 读 写
                .scopes("all")
                // false的话 请求到来的时候会跳转到授权页面
                .autoApprove(false)
                // 回调的地址 授权码会作为参数绑定在重定向的地址中
                .redirectUris("http://www.baidu.com");
    }


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // 管理认证管理器
        endpoints.authenticationManager(authenticationManager)
                // 授权码服务
        .authorizationCodeServices(authorizationCodeServices)
                // token服务
        .tokenServices(tokenServices())
                .allowedTokenEndpointRequestMethods(HttpMethod.GET,HttpMethod.POST);
    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();
    }

    /**
     * 功能描述: token令牌服务
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/10/18 16:48
     */
    @Bean
    public AuthorizationServerTokenServices tokenServices(){
        DefaultTokenServices services = new DefaultTokenServices();
        // 客户端的配置信息
        services.setClientDetailsService(clientDetailsService);
        // 支持刷新token
        services.setSupportRefreshToken(true);
        // 关联存储方式
        services.setTokenStore(tokenStore);
        // 令牌默认的有效期两小时
        services.setAccessTokenValiditySeconds(7200);
        // 刷新令牌默认的有效期3天
        services.setRefreshTokenValiditySeconds(259200);
        return services;
    }


    @Bean
    public AuthorizationCodeServices authorizationCodeServices(){
        return new InMemoryAuthorizationCodeServices();
    }

    /**
     * 功能描述: token信息存储在内存中
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/10/18 16:51
     */
    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }
}
