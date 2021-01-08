package com.hm.hospitalproject.mapper;

import com.hm.hospitalproject.entity.Prescription;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/08/7:08
 * @Description:
 */


public interface YaofangServer {
    List<Prescription> getAllbypatientId(int  patientId);

    void uppeiyao(int yaodanid1);

    void tuiyao(int caseId, int patient);

    void uppeiyao3(int yaodanid3);

    void uppeiyao2(int yaodanid2);

    void uppeiyao1(int yaodanid1);
}
