package com.hm.hospitalproject.server;

import com.hm.hospitalproject.entity.CaseRecoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/07/1:48
 * @Description:
 */


public interface CaserecoderServer {
    int addcaserecoder(CaseRecoder caseRecoder);

    List<CaseRecoder> getAllcasbypatientId(int patientId);


    CaseRecoder getcaseBycaseId(int id);
}
