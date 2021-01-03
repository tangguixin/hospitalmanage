package com.shyroke.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shyroke.entity.Medical;

public interface MedicalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Medical record);

    int insertSelective(Medical record);

    Medical selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Medical record);

    int updateByPrimaryKey(Medical record);

	List<Medical> selectAll();

	List<Medical> selectByName(@Param("name")String name);

	List<Medical> selectByZuoYong(@Param("zuoyong")String zuoyong);
}