package com.fan.gupao.demo;

/**
 * @author 樊高风
 * @date 2020/6/19 21:17
 */
public class CopTest {

    public static void main(String[] args) {

        ProductDao productDao = new ProductDao();
        productDao.setDbConnection(new MySqlConnection());
        productDao.addProduct();

    }
}
