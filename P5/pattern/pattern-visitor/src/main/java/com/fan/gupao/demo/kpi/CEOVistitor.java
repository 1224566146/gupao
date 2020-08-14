package com.fan.gupao.demo.kpi;

/**
 * @author 樊高风
 * @date 2020/8/14
 */
public class CEOVistitor implements IVisitor {
    @Override
    public void visit(Engineer engineer) {
        System.out.println("工程师:"+engineer.name+"KPI:"+engineer.kpi);
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("经理:"+manager.name+"KPI:"+manager.kpi+",产品数量:"+manager.getProducts());
    }
}
