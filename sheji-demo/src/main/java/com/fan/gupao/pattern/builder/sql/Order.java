package com.fan.gupao.pattern.builder.sql;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 15:22 2020/5/19
 */
public class Order {
    // 升序还是降序
    private boolean ascending;
    // 哪个字段升序，哪个字段降序
    private String propertyName;

    public Order(String propertyName, boolean ascending) {
        this.propertyName = propertyName;
        this.ascending = ascending;
    }

    @Override
    public String toString(){
        return propertyName+' '+(ascending?"asc":"desc");
    }



    public static Order asc(String propertyName){
        return new Order( propertyName, true);
    }

    public static Order desc(String propertyName){
        return new Order(propertyName, false);
    }
}
