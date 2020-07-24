package com.fan.gupao.demo.auth.optimiaze;

import com.fan.gupao.demo.auth.Member;
import org.apache.commons.lang.StringUtils;

/**
 * @author 樊高风
 * @date 2020/7/24
 */
public class ValidateHandler extends Handler {
    @Override
    public void doHandler(Member member) {
        if(StringUtils.isEmpty(member.getLoginName())||
                StringUtils.isEmpty(member.getLoginPass())){
            System.out.println("用户名和密码为空");
            return;
        }
        System.out.println("用户名和密码不为空,可以往下执行");
        next.doHandler(member);
    }
}
