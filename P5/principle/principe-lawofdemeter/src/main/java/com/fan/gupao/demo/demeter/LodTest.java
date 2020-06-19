package com.fan.gupao.demo.demeter;

/**
 * @author 樊高风
 * @date 2020/6/19 20:06
 */
public class LodTest {

    public static void main(String[] args) {

        TeamLeader teamLeader = new TeamLeader();
        Employee employee = new Employee();
        teamLeader.commandCheckNumber(employee);

    }
}
