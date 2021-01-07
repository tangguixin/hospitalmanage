package com.hm.hospitalproject.server.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hm.hospitalproject.entity.CaseRecoder;
import com.hm.hospitalproject.entity.DoctorInfo;
import com.hm.hospitalproject.mapper.CaseRecoderMapper;
import com.hm.hospitalproject.server.CaserecoderServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/07/12:40
 * @Description:
 */

@Service
public class CaserecoderServerImpl implements CaserecoderServer
{

    @Autowired
    CaseRecoderMapper caseRecoderMapper;

    @Override
    public int addcaserecoder(CaseRecoder caseRecoder) {
        return caseRecoderMapper.insert(caseRecoder);
    }

    @Override
    public List<CaseRecoder> getAllcas(int paintId) {
        QueryWrapper<CaseRecoder> queryWrapper = new QueryWrapper<CaseRecoder>();
        queryWrapper.eq("patients_id",paintId);

        return caseRecoderMapper.selectList(queryWrapper);
    }

    @Override
    public List<CaseRecoder> getpagecas(int start, int size) {
        QueryWrapper<CaseRecoder> queryWrapper = new QueryWrapper<CaseRecoder>();
        queryWrapper.isNotNull("patientsId");

        return caseRecoderMapper.selectList(queryWrapper);

    }

    @Override
    public CaseRecoder getcaseBycaseId(int id) {
        return caseRecoderMapper.selectById(id);
    }
}
