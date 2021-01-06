package com.hm.hospitalproject.mapper;

import com.hm.hospitalproject.entity.InspectionItems;

public interface InspectionItemsMapper {
    int deleteByPrimaryKey(Integer checkId);

    int insert(InspectionItems record);

    int insertSelective(InspectionItems record);

    InspectionItems selectByPrimaryKey(Integer checkId);

    int updateByPrimaryKeySelective(InspectionItems record);

    int updateByPrimaryKey(InspectionItems record);
}