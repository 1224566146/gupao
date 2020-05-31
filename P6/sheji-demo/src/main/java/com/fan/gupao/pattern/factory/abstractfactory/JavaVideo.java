package com.fan.gupao.pattern.factory.abstractfactory;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:30 2020/2/11
 */
public class JavaVideo implements IVideo {
    @Override
    public void record() {
        System.out.println("播放Java视频");
    }
}
