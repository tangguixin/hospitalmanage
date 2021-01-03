package com.shyroke.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shyroke.entity.SelectedMedical;

public interface SelectedMedicalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SelectedMedical record);

    int insertSelective(SelectedMedical record);

    SelectedMedical selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SelectedMedical record);

    int updateByPrimaryKey(SelectedMedical record);

	void deleteByDoctorId(@Param("doctorId")Integer doctorId);

	List<SelectedMedical> selectByDoctorId(@Param("doctorId")Integer doctorId);
}