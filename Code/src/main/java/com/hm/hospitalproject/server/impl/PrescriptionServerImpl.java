package com.hm.hospitalproject.server.impl;

import com.hm.hospitalproject.entity.Prescription;
import com.hm.hospitalproject.mapper.PrescriptionMapper;
import com.hm.hospitalproject.server.PrescriptionServer;
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
public class PrescriptionServerImpl implements PrescriptionServer {
    @Autowired
    PrescriptionMapper prescriptionMapper;
    @Override
    public Boolean addPrescription(Prescription prescription) {
        if (prescriptionMapper.insert(prescription)==1){
            return true;
        }
        return false;
    }
}
