package com.hm.hospitalproject.mapper;

import com.hm.hospitalproject.entity.RoomInfo;

public interface RoomInfoMapper {
    int deleteByPrimaryKey(Integer roomId);

    int insert(RoomInfo record);

    int insertSelective(RoomInfo record);

    RoomInfo selectByPrimaryKey(Integer roomId);

    int updateByPrimaryKeySelective(RoomInfo record);

    int updateByPrimaryKey(RoomInfo record);
}