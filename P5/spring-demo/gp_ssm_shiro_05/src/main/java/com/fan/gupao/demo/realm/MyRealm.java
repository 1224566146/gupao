package com.fan.gupao.demo.realm;

import com.fan.gupao.demo.bean.User;
import com.fan.gupao.demo.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 樊高风
 * @date 2020/8/18
 */
public class MyRealm extends AuthorizingRealm {


    @Autowired
    private IUserService userService;

    /**
     * 功能描述: 认证方法
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/8/18 17:22
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        List<User> list = userService.query(username);
        if(list == null || list.size() != 1){
            // 表示帐号不存在
            return null;
        }
        User user = list.get(0);
        return new SimpleAuthenticationInfo(user,user.getPassword(),new SimpleByteSource(user.getSalt()),"myrealm");
    }

    /**
     * 功能描述: 授权操作
     * @param
     * @return
     * @throws
     * @author 樊高风
     * @date 2020/8/19 9:49
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取当前认证成功的Subject
        User user = (User) principals.getPrimaryPrincipal();
        System.out.println("当前认证的帐号是:"+user.getName());
        // 去数据库查询当前用户具有的对应的权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole("admin");
        info.addRole("root");
        info.addRole("user");
        info.addStringPermission("USER_QUERY");
        info.addStringPermission("USER_CREATE");
        return info;
    }

}
