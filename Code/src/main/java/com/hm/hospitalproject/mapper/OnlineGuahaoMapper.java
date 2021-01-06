package com.hm.hospitalproject.mapper;

import com.hm.hospitalproject.entity.OnlineGuahao;

public interface OnlineGuahaoMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(OnlineGuahao record);

    int insertSelective(OnlineGuahao record);

    OnlineGuahao selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(OnlineGuahao record);

    int updateByPrimaryKey(OnlineGuahao record);
}