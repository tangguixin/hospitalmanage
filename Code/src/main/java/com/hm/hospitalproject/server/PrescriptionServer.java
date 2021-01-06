package com.hm.hospitalproject.server;

import com.hm.hospitalproject.entity.Prescription;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/07/1:44
 * @Description:
 */
@Service
public interface PrescriptionServer {
    Boolean addPrescription(Prescription prescription);
}
