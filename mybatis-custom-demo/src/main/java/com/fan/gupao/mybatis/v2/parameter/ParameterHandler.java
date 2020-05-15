package com.fan.gupao.mybatis.v2.parameter;

import java.sql.PreparedStatement;

/**
 * @Description: 参数处理器
 * @Author: 樊高风
 * @Date: 13:28 2020/5/15
 */
public class ParameterHandler {

    private PreparedStatement psmt;

    public ParameterHandler(PreparedStatement psmt) {
        this.psmt = psmt;
    }

    /**
     * 功能描述：从方法中获取参数，遍历设置SQL中的？占位符
     * @authorer: 樊高风
     * @date: 2020/5/15 13:30
     * @param:
     * @return:
     */
    public void setParameters(Object[] parameters){
        try {
            // PreparedStatement的序号是从1开始的
            for (int i = 0; i < parameters.length; i++) {
                int k = i+1;
                if (parameters[i] instanceof Integer) {
                    psmt.setInt(k, (Integer) parameters[i]);
                } else if (parameters[i] instanceof Long) {
                    psmt.setLong(k, (Long) parameters[i]);
                } else if (parameters[i] instanceof String) {
                    psmt.setString(k , String.valueOf(parameters[i]));
                } else if (parameters[i] instanceof Boolean) {
                    psmt.setBoolean(k, (Boolean) parameters[i]);
                } else {
                    psmt.setString(k, String.valueOf(parameters[i]));
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
