package com.hm.hospitalproject.mapper;

import com.hm.hospitalproject.entity.CheckIterm;

public interface CheckItermMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CheckIterm record);

    int insertSelective(CheckIterm record);

    CheckIterm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CheckIterm record);

    int updateByPrimaryKey(CheckIterm record);
}