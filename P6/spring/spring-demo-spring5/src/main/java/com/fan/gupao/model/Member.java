package com.fan.gupao.model;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:12 2020/5/7
 */
public class Member {

    private String mid;

    private String name;

    private String addr;

    private String info;

    public Member() {
    }

    public Member(String name) {
        this.name = name;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
