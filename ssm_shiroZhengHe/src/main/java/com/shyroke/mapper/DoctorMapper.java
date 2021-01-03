package com.shyroke.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shyroke.entity.Doctor;

public interface DoctorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Doctor record);

    int insertSelective(Doctor record);

    Doctor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Doctor record);

    int updateByPrimaryKey(Doctor record);

	List<Doctor> getDoctorsByDepartment(@Param("department")String department);

	int getTotalRecord(@Param("docname")String docname);

	/**
	 * 由医生姓名获取医生
	 * @param doctor
	 * @return
	 */
	Doctor getDoctorByName(@Param("name")String doctor);
}