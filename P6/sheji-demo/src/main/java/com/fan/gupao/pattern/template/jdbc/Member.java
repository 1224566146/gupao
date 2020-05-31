package com.fan.gupao.pattern.template.jdbc;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 19:39 2020/3/6
 */
public class Member {


    private String userName;

    private String passWord;

    private String nickName;

    private int age;

    private String addr;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
