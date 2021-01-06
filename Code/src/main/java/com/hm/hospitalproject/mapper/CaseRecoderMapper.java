package com.hm.hospitalproject.mapper;

import com.hm.hospitalproject.entity.CaseRecoder;

public interface CaseRecoderMapper {
    int deleteByPrimaryKey(Integer caseId);

    int insert(CaseRecoder record);

    int insertSelective(CaseRecoder record);

    CaseRecoder selectByPrimaryKey(Integer caseId);

    int updateByPrimaryKeySelective(CaseRecoder record);

    int updateByPrimaryKey(CaseRecoder record);
}