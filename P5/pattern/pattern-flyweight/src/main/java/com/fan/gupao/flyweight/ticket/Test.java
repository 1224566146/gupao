package com.fan.gupao.flyweight.ticket;

/**
 * @author 樊高风
 * @date 2020/6/28
 */
public class Test {

    public static void main(String[] args) {

        ITicket ticket = TicketFactory.queryTicket("北京西", "长沙");
        ticket.showInfo("硬座");
        ticket = TicketFactory.queryTicket("北京西", "长沙");
        ticket.showInfo("软座");
        ticket = TicketFactory.queryTicket("长沙", "北京西");
        ticket.showInfo("硬卧");
    }
}
