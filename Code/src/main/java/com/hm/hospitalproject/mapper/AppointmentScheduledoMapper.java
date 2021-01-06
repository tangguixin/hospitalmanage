package com.hm.hospitalproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hm.hospitalproject.entity.AppointmentScheduledo;

public interface AppointmentScheduledoMapper extends BaseMapper<AppointmentScheduledo> {
    int deleteByPrimaryKey(String doctorName);

    int insert(AppointmentScheduledo record);

    int insertSelective(AppointmentScheduledo record);

    AppointmentScheduledo selectByPrimaryKey(String doctorName);

    int updateByPrimaryKeySelective(AppointmentScheduledo record);

    int updateByPrimaryKey(AppointmentScheduledo record);
}