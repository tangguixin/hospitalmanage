package com.hm.hospitalproject.server;

import com.hm.hospitalproject.entity.CaseRecoder;
import com.hm.hospitalproject.entity.DoctorInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/07/1:48
 * @Description:
 */

@Service
public interface CaserecoderServer {
    Boolean addcaserecoder(CaseRecoder caseRecoder);

    List<CaseRecoder> getAllcas();
    List<CaseRecoder> getpagecas(int start,int size);

    CaseRecoder getcaseBycaseId(int id);
}
