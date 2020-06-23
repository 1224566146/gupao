package com.fan.gupao.demo.points;

/**
 * @author 樊高风
 * @date 2020/6/23 16:07
 */
public class Test {

    public static void main(String[] args) {

        FacadeService facadeService = new FacadeService();

        GiftInfo giftInfo = new GiftInfo("抱枕");

        facadeService.exchange(giftInfo);

    }
}
