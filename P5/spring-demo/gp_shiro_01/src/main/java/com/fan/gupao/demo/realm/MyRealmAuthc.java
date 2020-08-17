package com.fan.gupao.demo.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author 樊高风
 * @date 2020/8/17
 */
public class MyRealmAuthc extends AuthorizingRealm {
    /**
     * 功能描述: 授权操作方法
     *
     * @param principalCollection
     *      一定要注意,该参数和doGetAuthenticationInfo【该类中的另一个方法】返回的SimpleAuthenticationInfo中的第一个参数有关
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/8/17 16:10
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName  = (String) principalCollection.getPrimaryPrincipal();
        System.out.println("需要授权的帐号是:"+userName);
        // 根据当前通过认证的帐号去数据库查询对应的权限信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole("role1");
        info.addRole("role2");
        info.addStringPermission("user:create");
        return info;
    }

    /**
     * 功能描述: 完成自定义的帐号验证
     *
     * @param authenticationToken
     * @return 返回null表示 帐号不存在
     * @throws
     * @author 樊高风
     * @date 2020/8/17 15:21
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        System.out.println("提交的帐号是Authc:" + token.getUsername());
        // 根据帐号去数据库中查询对应的记录
        if (!"zhang".equals(token.getUsername())) {
            // 表示帐号不存在
            return null;
        }
        // 表示帐号存在
        // 表示数据库中查询的密码是123
        String password = "123";
        return new SimpleAuthenticationInfo(token.getUsername(), password, "myRealm");
    }
}
