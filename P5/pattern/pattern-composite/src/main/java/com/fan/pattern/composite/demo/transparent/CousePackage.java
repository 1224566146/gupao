package com.fan.pattern.composite.demo.transparent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 樊高风
 * @date 2020/6/29
 */
public class CousePackage extends CourseComponent {

    private List<CourseComponent> itesm = new ArrayList<>();
    private String name;
    private Integer level;

    public CousePackage(String name, Integer level) {
        this.name = name;
        this.level = level;
    }


    @Override
    public void addChild(CourseComponent catalogComponent) {
        itesm.add(catalogComponent);
    }

    @Override
    public void removeChild(CourseComponent catalogComponent) {
        itesm.remove(catalogComponent);
    }

    @Override
    public String getName(CourseComponent catalogComponent) {
        return this.name;
    }

    @Override
    public void print() {
        System.out.println(this.name);

        for (CourseComponent courseComponent : itesm) {
            // 控制显示格式
            if(this.level != null){
                for (int i = 0; i < this.level; i++) {
                    // 打印空格控制格式
                    System.out.print("    ");
                }
                for (int i = 0; i < this.level; i++) {
                    // 每一行开始打印一个+号
                    if(i == 0){
                        System.out.print("+");
                    }
                    System.out.print("-");
                }
            }
            // 打印标题
            courseComponent.print();
        }
    }
}
