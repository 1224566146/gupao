package com.fan.gupao.demo.realm;

import com.fan.gupao.demo.bean.User;
import com.fan.gupao.demo.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 樊高风
 * @date 2020/8/19
 */
public class MyRealmSha1 extends AuthorizingRealm {


    @Autowired
    private IUserService userService;

    /**
     * 功能描述: 认证的方法
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/8/19 9:16
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        System.out.println("SHA1认证:"+username);
        List<User> list = userService.querySha1(username);
        if(list == null || list.size() != 1){
            return null;
        }
        User user = list.get(0);
        return new SimpleAuthenticationInfo(user,user.getPassword(),new SimpleByteSource(user.getSalt()),"myrealmSha1");
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }


}
