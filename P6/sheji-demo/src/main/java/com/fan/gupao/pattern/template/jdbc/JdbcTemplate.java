package com.fan.gupao.pattern.template.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 19:41 2020/3/6
 */
public abstract class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource){
        this.dataSource = dataSource;
    }


    public List<?> executeQuery(String sql,RowMapper<?> rowMapper,Object [] values){

        try {

            //1、获取链接
            Connection connection = getConnection();

            //2、创建语句集
            PreparedStatement preparedStatement = createPreparedStatement(connection, sql);

            //3、执行语句集
            ResultSet resultSet = this.executeQuery(preparedStatement, values);

            //4、处理结果集
            List<?> objects = this.parseResultSet(resultSet, rowMapper);

            //5、关闭结果集
            this.closeResultSet(resultSet);

            //6、关闭语句集
            this.closeStatement(preparedStatement);

            //7、关闭连接
            this.closeConnection(connection);

            return objects;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    protected void closeConnection(Connection connection) throws  Exception{
        //数据库连接池，我们不是关闭
        connection.close();
    }

    protected void closeStatement(PreparedStatement pstm) throws Exception{
        pstm.close();
    }

    protected void closeResultSet(ResultSet rs) throws Exception{
        rs.close();
    }


    protected List<?> parseResultSet(ResultSet rs,RowMapper<?> rowMapper) throws Exception{
        List<Object> result = new ArrayList<>();
        int rowNum = 1;
        while (rs.next()){
            result.add(rowMapper.mapRow(rs, rowNum++));
        }
        return result;
    }

    protected ResultSet executeQuery(PreparedStatement pstm,Object [] values) throws Exception{
        for (int i = 0; i <values.length; i++){
            pstm.setObject(i, values[i]);
        }
        return pstm.executeQuery();
    }


    protected PreparedStatement createPreparedStatement(Connection conn,String sql) throws Exception{
        return conn.prepareStatement(sql);
    }


    public Connection getConnection() throws Exception{
        return this.dataSource.getConnection();
    }




}
