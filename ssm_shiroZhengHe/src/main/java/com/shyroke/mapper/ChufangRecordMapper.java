package com.shyroke.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shyroke.entity.ChufangRecord;

public interface ChufangRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChufangRecord record);

    int insertSelective(ChufangRecord record);

    ChufangRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChufangRecord record);

    int updateByPrimaryKey(ChufangRecord record);

	List<ChufangRecord> selectByPatientId(@Param("patientId")Integer patientId);
}