package com.hm.hospitalproject.server.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hm.hospitalproject.entity.PatientInfo;
import com.hm.hospitalproject.entity.Prescription;
import com.hm.hospitalproject.mapper.PrescriptionMapper;
import com.hm.hospitalproject.mapper.YaofangServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/08/7:08
 * @Description:
 */
@Service
public class YaofangServerImpl implements YaofangServer {

    @Autowired
    PrescriptionMapper prescriptionMapper;
    @Override
    public List<Prescription> getAllbypatientId(int patientId) {
        QueryWrapper<Prescription> queryWrapper = new QueryWrapper<Prescription>();
        queryWrapper.eq("patient_id",patientId);
        return prescriptionMapper.selectList(queryWrapper);
    }

    @Override
    public void uppeiyao(int yaodanid1) {

        Prescription prescription1= prescriptionMapper.selectById(yaodanid1);
        prescription1.setJiesuan(1);

        prescriptionMapper.updateById(prescription1);

    }

    @Override
    public void tuiyao(int caseId, int patient) {
        QueryWrapper<Prescription> queryWrapper = new QueryWrapper<Prescription>();
        queryWrapper.eq("id",caseId);

        List<Prescription> list=prescriptionMapper.selectList(queryWrapper);
        for (Prescription s:list){
            s.setJiesuan(-1);
            prescriptionMapper.updateById(s);
        }
    }

    @Override
    public void uppeiyao3(int  yaodanid3) {
        Prescription prescription=prescriptionMapper.selectById(yaodanid3);
        prescription.setJiesuan(4);
        prescriptionMapper.updateById(prescription);

    }

    @Override
    public void uppeiyao2(int  yaodanid2) {
        Prescription prescription=prescriptionMapper.selectById(yaodanid2);
        prescription.setJiesuan(3);
        prescriptionMapper.updateById(prescription);

    }

    @Override
    public void uppeiyao1(int yaodanid1) {
        Prescription prescription=prescriptionMapper.selectById(yaodanid1);
        prescription.setJiesuan(2);
        prescriptionMapper.updateById(prescription);

    }
}
