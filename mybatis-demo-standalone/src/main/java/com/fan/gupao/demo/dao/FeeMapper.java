package com.fan.gupao.demo.dao;

import com.fan.gupao.demo.entity.Fee;

import java.util.List;

public interface FeeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Fee record);

    int insertSelective(Fee record);

    Fee selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Fee record);

    int updateByPrimaryKey(Fee record);

    List<Fee> selectByFeeDate(Fee fee);
}