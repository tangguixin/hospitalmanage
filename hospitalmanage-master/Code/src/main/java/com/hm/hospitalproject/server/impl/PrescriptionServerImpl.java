package com.hm.hospitalproject.server.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hm.hospitalproject.entity.Prescription;
import com.hm.hospitalproject.entity.Users;
import com.hm.hospitalproject.mapper.PrescriptionMapper;
import com.hm.hospitalproject.server.PrescriptionServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/07/12:42
 * @Description:
 */


@Service
public class PrescriptionServerImpl implements PrescriptionServer {

    @Autowired
    PrescriptionMapper prescriptionMapper;

    @Override
    public Boolean addPrescription(Prescription prescription) {
      prescriptionMapper.insert(prescription) ;
    return true;
    }

    @Override
    public List<Prescription> getAll() {
        return prescriptionMapper.selectList(null);
    }

    @Override
    public boolean addone(int patientId, int doctorId, int drugId) {
        Prescription prescription=new Prescription();
        prescription.setPatientId(patientId);
        prescription.setDrugid(drugId);
        prescription.setDoctorId(doctorId);
        prescriptionMapper.insert(prescription);
        return true;
    }

    @Override
    public List<Prescription> getallBypaintId(Integer userId) {
        QueryWrapper<Prescription> qw = new QueryWrapper<>();
        qw.eq("patient_id",userId);
       return prescriptionMapper.selectList(qw);

    }
}
