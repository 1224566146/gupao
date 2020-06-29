package com.fan.gupao.flyweight.ticket;

import java.util.Random;

/**
 * @author 樊高风
 * @date 2020/6/28
 */
public class TrainTicket implements ITicket {

    private String from;
    private String to;
    private int price;

    public TrainTicket(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void showInfo(String bunk) {
        this.price = new Random().nextInt(500);
        System.out.println(String.format("%s->%s:%s价格:%s元", this.from,this.to,bunk,this.price));
    }
}
