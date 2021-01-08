package com.hm.hospitalproject.server;

import com.hm.hospitalproject.entity.Prescription;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/07/1:44
 * @Description:
 */



public interface PrescriptionServer {
    Boolean addPrescription(Prescription prescription);
    List<Prescription> getAll();

    boolean addone(int patientId, int doctorId, int drugId);

    List<Prescription> getallBypaintId(Integer userId);
}
