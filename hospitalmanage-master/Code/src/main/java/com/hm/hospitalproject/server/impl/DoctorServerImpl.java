package com.hm.hospitalproject.server.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hm.hospitalproject.entity.DoctorInfo;
import com.hm.hospitalproject.entity.RoomInfo;
import com.hm.hospitalproject.mapper.DoctorInfoMapper;
import com.hm.hospitalproject.mapper.RoomInfoMapper;
import com.hm.hospitalproject.server.DoctorServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/07/10:19
 * @Description:
 */

@Service
public class DoctorServerImpl implements DoctorServer {


    @Autowired
    DoctorInfoMapper doctorInfoMapper;
    @Autowired
    RoomInfoMapper roomInfoMapper;

    @Override
    public DoctorInfo getDoctorInfoByshenfenzheng(String shenfenzheng) {
        QueryWrapper<DoctorInfo> queryWrapper = new QueryWrapper<DoctorInfo>();
        queryWrapper.eq("shenfenzheng",shenfenzheng);
        return doctorInfoMapper.selectOne(queryWrapper);
    }

    @Override
    public List<DoctorInfo> getAllDoctorInfo() {

        return  doctorInfoMapper.selectList(null);
    }



    @Override
    public DoctorInfo getDoctorInfoByid(int id) {
        return doctorInfoMapper.selectById(id);
    }



    @Override
    public List<DoctorInfo> getAllDoctorInfoByRoomId(Integer roomId) {
        RoomInfo roomInfo=roomInfoMapper.selectById(roomId);
        QueryWrapper<DoctorInfo> queryWrapper = new QueryWrapper<DoctorInfo>();
        queryWrapper.eq("offices_name",roomInfo.getRoomname());

        return doctorInfoMapper.selectList(queryWrapper);
    }
}
