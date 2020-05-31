package com.fan.gupao.transaction.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 17:00 2020/5/2
 */
@Entity
@Table(name = "t_member")
@Data
public class Member implements Serializable {

    @Id
    private Long id;

    private String name;

    private String addr;

    private Integer age;

    public Member() {
    }

    public Member(String name, String addr, Integer age) {
        this.name = name;
        this.addr = addr;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", age=" + age +
                '}';
    }
}
