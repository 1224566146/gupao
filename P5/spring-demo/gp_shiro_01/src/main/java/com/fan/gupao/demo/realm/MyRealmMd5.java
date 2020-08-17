package com.fan.gupao.demo.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;

/**
 * @author 樊高风
 * @date 2020/8/17
 */
public class MyRealmMd5 extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 功能描述: 完成自定义的帐号验证
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/8/17 15:41
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        System.out.println("提交的帐号是MD5:"+token.getUsername());
        // 根据帐号去数据库中查询对应的记录
        if(!"zhang".equals(token.getUsername())){
            // 表示帐号不存在
            return null;
        }
        // 表示帐号存在
        // 表示数据库中查询的密码是123456
        String password = "b8d63fc060e2b5651e8cb4e71ba61e6f";
        // 盐值
        String salt = "aaa";
        return new SimpleAuthenticationInfo(token.getUsername(),password,new SimpleByteSource(salt),"myRealmMd5");
    }
}
