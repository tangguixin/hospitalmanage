package com.hm.hospitalproject.server.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hm.hospitalproject.entity.PatientInfo;
import com.hm.hospitalproject.entity.Users;
import com.hm.hospitalproject.mapper.PatientInfoMapper;
import com.hm.hospitalproject.server.PatientServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/07/12:42
 * @Description:
 */

@Service
public class PatientServerImpl implements PatientServer {

    @Autowired
    PatientInfoMapper patientInfoMapper;

    @Override
    public PatientInfo getPatientInfoByshenfenzheng(String shenfenzheng) {
        QueryWrapper<PatientInfo> queryWrapper = new QueryWrapper<PatientInfo>();
        queryWrapper.eq("shenfenzheng",shenfenzheng);
        return patientInfoMapper.selectOne(queryWrapper);
    }
}
