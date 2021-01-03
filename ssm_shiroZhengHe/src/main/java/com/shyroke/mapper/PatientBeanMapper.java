package com.shyroke.mapper;

import org.apache.ibatis.annotations.Param;

import com.shyroke.entity.PatientBean;

public interface PatientBeanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PatientBean record);

    int insertSelective(PatientBean record);

    PatientBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PatientBean record);

    int updateByPrimaryKey(PatientBean record);

	PatientBean selectPatientByUserId(@Param("patientId")Integer patientId);

	PatientBean selectPatientByTrueName(@Param("patientname")String patientname);
}