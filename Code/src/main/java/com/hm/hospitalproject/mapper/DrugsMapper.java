package com.hm.hospitalproject.mapper;

import com.hm.hospitalproject.entity.Drugs;
import org.springframework.stereotype.Component;

@Component
public interface DrugsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Drugs record);

    int insertSelective(Drugs record);

    Drugs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Drugs record);

    int updateByPrimaryKey(Drugs record);
}