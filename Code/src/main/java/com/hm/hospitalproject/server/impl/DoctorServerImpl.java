package com.hm.hospitalproject.server.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hm.hospitalproject.entity.DoctorInfo;
import com.hm.hospitalproject.entity.RoomInfo;
import com.hm.hospitalproject.mapper.DoctorInfoMapper;
import com.hm.hospitalproject.server.DoctorServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
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

    @Override
    public DoctorInfo getDoctorInfoByshenfenzheng(String shenfenzheng) {
        QueryWrapper<DoctorInfo> queryWrapper = new QueryWrapper<DoctorInfo>();
        queryWrapper.eq("shenfenzheng",shenfenzheng);
        return doctorInfoMapper.selectOne(queryWrapper);
    }

    @Override
    public List<DoctorInfo> getAllDoctorInfo() {
        QueryWrapper<DoctorInfo> queryWrapper = new QueryWrapper<DoctorInfo>();
        queryWrapper.isNotNull("doctorName");
        return  doctorInfoMapper.selectList(queryWrapper);
    }

    @Override
    public List<DoctorInfo> getpageDoctorInfo(int start, int size) {
        QueryWrapper<DoctorInfo> queryWrapper = new QueryWrapper<DoctorInfo>();
        queryWrapper.isNotNull("doctorName");
        doctorInfoMapper.selectBatchIds((Collection<? extends Serializable>) queryWrapper);
        return doctorInfoMapper.selectList(queryWrapper);
    }

    @Override
    public List<DoctorInfo> getdoctorByroomname(String roomname) {
        QueryWrapper<DoctorInfo> queryWrapper = new QueryWrapper<DoctorInfo>();
        queryWrapper.eq("officesName",roomname);
        return doctorInfoMapper.selectList(queryWrapper);
    }

    @Override
    public DoctorInfo getDoctorInfoByid(int id) {
        return doctorInfoMapper.selectById(id);
    }
}
