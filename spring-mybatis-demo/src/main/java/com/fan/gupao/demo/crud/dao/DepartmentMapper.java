package com.fan.gupao.demo.crud.dao;

import com.fan.gupao.demo.crud.bean.Department;

import java.util.List;

/**
 * @Author: qingshan
 */
public interface DepartmentMapper {

    int deleteByPrimaryKey(Integer deptId);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByMap(Object o);
}