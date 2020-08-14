package com.fan.gupao.demo.kpi;

/**
 * @author 樊高风
 * @date 2020/8/14
 */
public class Test {

    public static void main(String[] args) {

        BusinessReport report = new BusinessReport();
        System.out.println("==============CEO看报表====================");
        report.showReport(new CEOVistitor());
        System.out.println("==============CTO看报表====================");
        report.showReport(new CTOVistitor());

    }
}
