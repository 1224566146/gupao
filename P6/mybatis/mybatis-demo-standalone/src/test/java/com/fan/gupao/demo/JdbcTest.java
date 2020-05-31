package com.fan.gupao.demo;

import com.fan.gupao.demo.domain.Blog;
import org.junit.Test;

import java.io.IOException;
import java.sql.*;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 20:39 2020/5/8
 */
public class JdbcTest {

    @Test
    public void testJdbc() throws IOException {
        Connection conn = null;
        Statement stmt = null;
        Blog blog = new Blog();

        try {
            // 注册 JDBC 驱动
            // Class.forName("com.mysql.jdbc.Driver");

            // 打开连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis", "root", "525.xiang");

            // 执行查询
            stmt = conn.createStatement();
            String sql = "SELECT bid,name,author_id FROM blog where bid = 1000";
            ResultSet rs = stmt.executeQuery(sql);

            // 获取结果集
            while (rs.next()) {
                Integer bid = rs.getInt("bid");
                String name = rs.getString("name");
                Integer authorId = rs.getInt("author_id");
                blog.setAuthorId(authorId);
                blog.setBid(bid);
                blog.setName(name);
            }
            System.out.println(blog);

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testJdbcBatch() throws IOException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Long start = System.currentTimeMillis();
            // 打开连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis", "root", "525.xiang");

            ps = conn.prepareStatement("INSERT into blog values (?,?,?)");

            for (int i = 0; i < 10000; i++) {
                Blog blog = new Blog();
                ps.setInt(1, i);
                ps.setString(2, String.valueOf(i) + "");
                ps.setInt(3, 1001);
                ps.addBatch();
            }

            ps.executeBatch();


            ps.close();
            conn.close();

            Long end = System.currentTimeMillis();
            System.out.println("cost:" + (end - start) + "ms");

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
