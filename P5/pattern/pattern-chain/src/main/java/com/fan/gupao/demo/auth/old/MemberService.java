package com.fan.gupao.demo.auth.old;

import com.fan.gupao.demo.auth.Member;
import org.apache.commons.lang.StringUtils;

/**
 * @author 樊高风
 * @date 2020/7/24
 */
public class MemberService {


    public void login(String loginName,String loginPass){
        if(StringUtils.isEmpty(loginName) ||
        StringUtils.isEmpty(loginPass)){
            System.out.println("用户名和密码为空");
            return;
        }
        System.out.println("用户名和密码不为空,可以往下执行");

        Member member = checkExists(loginName, loginPass);
        if(null == member){
            System.out.println("用户不存在");
            return;
        }

        System.out.println("登录成功!");

        if(!"管理员".equals(member.getRoleName())){
            System.out.println("您不是管理员,没有操作权限");
            return;
        }
        System.out.println("允许操作");
    }


    private Member checkExists(String loginName,String loginPass){
        Member member = new Member(loginName, loginPass);
        member.setRoleName("管理员");
        return member;
    }

    public static void main(String[] args) {
        MemberService memberService = new MemberService();
        memberService.login("tom", "666");
    }

}
