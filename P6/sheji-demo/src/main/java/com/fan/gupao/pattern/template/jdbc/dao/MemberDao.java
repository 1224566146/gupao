package com.fan.gupao.pattern.template.jdbc.dao;

import com.fan.gupao.pattern.template.jdbc.JdbcTemplate;
import com.fan.gupao.pattern.template.jdbc.Member;
import com.fan.gupao.pattern.template.jdbc.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 19:40 2020/3/6
 */
public class MemberDao extends JdbcTemplate {



    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }


    public List<?> selectAll(){

        String sql = "select * from t_member";

        return super.executeQuery(sql, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws Exception {

                Member member = new Member();
                //字段过多，原型模式
                member.setUserName(rs.getString("userName"));
                member.setPassWord(rs.getString("passWord"));
                member.setAddr(rs.getString("addr"));
                member.setAge(rs.getInt("age"));

                return member;
            }
        }, null);

    }

}
