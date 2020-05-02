package com.fan.gupao.transaction.service;

import com.fan.gupao.transaction.dao.MemberDao;
import com.fan.gupao.transaction.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 16:59 2020/5/2
 */
@Service
public class MemberService {


    @Autowired
    private MemberDao memberDao;

    public List<Member> queryAll() throws Exception{
        return memberDao.selectAll();
    }

    public boolean add(Member member) throws Exception{
        boolean insert = memberDao.insert(member);
//        throw new Exception("自定义异常");
        return insert;
    }

    public boolean remove(long id) throws Exception{
        boolean delete = memberDao.delete(id);
        throw  new Exception("自定义异常");
    }

    public boolean modify(long id, String name) throws Exception{
        return memberDao.update(id, name);
    }

    public boolean login(long id, String name) throws Exception{
        boolean modify = this.modify(id, name);
        throw  new Exception("测试无事务");
//        return modify;
    }

}
