package com.fan.gupao.mybatis.v2.executor;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description: 结果集处理器
 * @Author: 樊高风
 * @Date: 12:53 2020/5/15
 */
public class ResultSetHandler {

    public <T> T handle(ResultSet resultSet, Class type){
        // 直接调用Class的newInstance方法产生一个实例
        Object pojo = null;
        try {
            pojo = type.newInstance();
            // 遍历结果集
            if(resultSet.next()){
                // 循环赋值
                for (Field field : pojo.getClass().getDeclaredFields()) {
                    setValue(pojo,field,resultSet);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return (T)pojo;
    }

    /**
     * 功能描述：通过反射给属性赋值
     * @authorer: 樊高风
     * @date: 2020/5/15 13:01
     * @param:
     * @return:
     */
    private void setValue(Object pojo, Field field,ResultSet rs){
        try {
            // 获取pojo的set方法
            Method method = pojo.getClass().getMethod("set" + firstWordCapital(field.getName()), field.getType());
            // 调用pojo的set方法，使用结果集给属性赋值
            // 赋值先从resultSet取出值
            method.invoke(pojo, getResult(rs,field));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 根据反射判断类型，从ResultSet中取对应类型参数
     */
    private Object getResult(ResultSet rs, Field field) throws SQLException {
        //TODO TypeHandler
        Class type = field.getType();
        String dataName = HumpToUnderline(field.getName()); // 驼峰转下划线
        // TODO 类型判断不够全
        if (Integer.class == type ) {
            return rs.getInt(dataName);
        }else if (String.class == type) {
            return rs.getString(dataName);
        }else if(Long.class == type){
            return rs.getLong(dataName);
        }else if(Boolean.class == type){
            return rs.getBoolean(dataName);
        }else if(Double.class == type){
            return rs.getDouble(dataName);
        }else{
            return rs.getString(dataName);
        }
    }

    /**
     *
     * @authorer: 樊高风 
     * @date: 2020/5/15 13:02
     * @param:  
     * @return:  
     */
    public static String HumpToUnderline(String para){
        StringBuilder sb=new StringBuilder(para);
        int temp=0;
        if (!para.contains("_")) {
            for(int i=0;i<para.length();i++){
                if(Character.isUpperCase(para.charAt(i))){
                    sb.insert(i+temp, "_");
                    temp+=1;
                }
            }
        }
        return sb.toString().toUpperCase();
    }

    /**
     * 单词首字母大写
     */
    private String firstWordCapital(String word){
        String first = word.substring(0, 1);
        String tail = word.substring(1);
        return first.toUpperCase() + tail;
    }
}
