package com.hm.hospitalproject.mapper;

import com.hm.hospitalproject.entity.Finance;

public interface FinanceMapper {
    int deleteByPrimaryKey(Integer financeId);

    int insert(Finance record);

    int insertSelective(Finance record);

    Finance selectByPrimaryKey(Integer financeId);

    int updateByPrimaryKeySelective(Finance record);

    int updateByPrimaryKey(Finance record);
}