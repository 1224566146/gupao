package com.fan.gupao.transaction.dao;

import com.fan.gupao.transaction.entity.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 17:03 2020/5/2
 */
@Repository
public class MemberDao {

    private JdbcTemplate template;

    @Resource(name = "dataSource")
    protected void setDataSource(DataSource dataSource){
        template = new JdbcTemplate(dataSource);
    }

    public List<Member> selectAll() throws Exception{

        String sql = "select * from t_member";
        return template.query(sql, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet resultSet, int i) throws SQLException {
                Member member = new Member();
                member.setName(resultSet.getString("name"));
                member.setId(resultSet.getLong("id"));
                member.setAddr(resultSet.getString("addr"));
                member.setAge(resultSet.getInt("age"));
                return member;
            }
        });

    }

    public boolean insert(Member m)throws Exception{
        String sql = "insert into t_member(id,name,addr,age) value(?,?,?,?)";
        int count = template.update(sql,m.getId(),m.getName(),m.getAddr(),m.getAge());
        return count > 0;
    }

    public boolean delete(long id) throws Exception{
        return template.update("delete from t_member where id = ?",id) > 0;
    }

    public boolean update(long id, String name) throws Exception{
        return template.update("update t_member set name = ? where id = ?",name,id) > 0;
    }

}
