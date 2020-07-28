package com.fan.gupao.demo.goodsserviceprovider.mapper.persistence;

import com.fan.gupao.demo.goodsserviceprovider.mapper.entitys.TbItem;
import com.fan.gupao.demo.goodsserviceprovider.mapper.entitys.TbItemExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TbItemMapper {
    long countByExample(TbItemExample example);

    int deleteByExample(TbItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbItem record);

    int insertSelective(TbItem record);

    List<TbItem> selectByExample(TbItemExample example);

    TbItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbItem record, @Param("example") TbItemExample example);

    int updateByExample(@Param("record") TbItem record, @Param("example") TbItemExample example);

    int updateByPrimaryKeySelective(TbItem record);

    int updateByPrimaryKey(TbItem record);

    List<TbItem> selectStockForUpdate(@Param("ids")List<Long> ids);

    int decreaseStock(@Param("record")TbItem record);
}