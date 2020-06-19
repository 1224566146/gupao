package com.fan.gupao.demo;

/**
 * @author 樊高风
 * @date 2020/6/19 21:16
 */
public class ProductDao {

    private DBConnection dbConnection;

    public void setDbConnection(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void addProduct(){
        String conn = dbConnection.getConnection();
        System.out.println("获得数据库链接"+conn);
    }
}
