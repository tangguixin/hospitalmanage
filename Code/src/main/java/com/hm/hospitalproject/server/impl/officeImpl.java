package com.hm.hospitalproject.server.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hm.hospitalproject.entity.PatientInfo;
import com.hm.hospitalproject.entity.RoomInfo;
import com.hm.hospitalproject.mapper.RoomInfoMapper;
import com.hm.hospitalproject.server.office;
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
public class officeImpl implements office {

    @Autowired
    RoomInfoMapper roomInfoMapper;
    @Override
    public List<RoomInfo> getAllroos() {
        QueryWrapper<RoomInfo> queryWrapper = new QueryWrapper<RoomInfo>();
        queryWrapper.isNotNull("roomname");
        List<RoomInfo> list = roomInfoMapper.selectList(queryWrapper);
        return list;
    }

    @Override
    public RoomInfo findroomByid(int id) {
        return roomInfoMapper.selectById(id);
    }
}
