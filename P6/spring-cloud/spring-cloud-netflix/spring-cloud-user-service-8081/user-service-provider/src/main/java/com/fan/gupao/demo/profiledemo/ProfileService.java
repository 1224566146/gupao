package com.fan.gupao.demo.profiledemo;

/**
 * @author 樊高风
 * @date 2020/7/16
 */
public class ProfileService {

    private String profile;

    public ProfileService(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "ProfileService{" +
                "profile='" + profile + '\'' +
                '}';
    }
}
