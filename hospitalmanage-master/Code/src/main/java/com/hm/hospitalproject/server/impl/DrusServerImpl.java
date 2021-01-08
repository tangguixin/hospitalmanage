package com.hm.hospitalproject.server.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hm.hospitalproject.entity.Drugs;
import com.hm.hospitalproject.entity.InspectionItems;
import com.hm.hospitalproject.mapper.DrugsMapper;
import com.hm.hospitalproject.server.DrusServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/07/12:41
 * @Description:
 */

@Service
public class DrusServerImpl implements DrusServer {

    @Autowired
    DrugsMapper drugsMapper;

    @Override
    public List<Drugs> getAllDrus() {

        return drugsMapper.selectList(null);
    }
}
