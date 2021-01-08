package com.hm.hospitalproject.server.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hm.hospitalproject.entity.CaseRecoder;
import com.hm.hospitalproject.entity.CheckIterm;
import com.hm.hospitalproject.mapper.CheckItermMapper;
import com.hm.hospitalproject.server.CheckServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/07/12:41
 * @Description:
 */

@Service
public class CheckServerImpl implements CheckServer {

    @Autowired
    CheckItermMapper checkItermMapper;


    @Override
    public boolean addCheck(int patientId, int doctorId, int checkId) {



        CheckIterm checkIterm=new CheckIterm();
        checkIterm.setDoctorId(doctorId);
        checkIterm.setPatientId(patientId);
        checkIterm.setCheckId(checkId);
        checkItermMapper.insert(checkIterm);
        return true;
    }
}
