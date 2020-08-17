package com.fan.gupao.demo.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author 樊高风
 * @date 2020/8/17
 */
public class MyRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 功能描述: 完成自定义的帐号验证
     * @param authenticationToken
     * @return
     *      返回null表示 帐号不存在
     * @throws
     * @author 樊高风
     * @date 2020/8/17 15:21
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        System.out.println("提交的帐号是:"+token.getUsername());
        // 根据帐号去数据库中查询对应的记录
        if(!"zhang".equals(token.getUsername())){
            // 表示帐号不存在
            return null;
        }
        // 表示帐号存在
        // 表示数据库中查询的密码是123
        String password = "123";
        return new SimpleAuthenticationInfo(token.getUsername(),password,"myRealm");
    }
}
