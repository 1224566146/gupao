package com.fan.gupao.demo.kpi;

/**
 * @author 樊高风
 * @date 2020/8/14
 */
public class CTOVistitor implements IVisitor {
    @Override
    public void visit(Engineer engineer) {
        System.out.println("工程师:"+engineer.name+",代码行数:"+engineer.getCodeLines());
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("经理:"+manager.name+",产品数量:"+manager.getProducts());
    }
}
