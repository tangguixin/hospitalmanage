package com.hm.hospitalproject.mapper;

import com.hm.hospitalproject.entity.PatientInfo;

public interface PatientInfoMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(PatientInfo record);

    int insertSelective(PatientInfo record);

    PatientInfo selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(PatientInfo record);

    int updateByPrimaryKey(PatientInfo record);
}