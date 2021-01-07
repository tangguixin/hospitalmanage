package com.hm.hospitalproject.server.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hm.hospitalproject.entity.InspectionItems;
import com.hm.hospitalproject.entity.RoomInfo;
import com.hm.hospitalproject.mapper.InspectionItemsMapper;
import com.hm.hospitalproject.server.InspectionItemsServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/07/2:26
 * @Description:
 */


@Service
public class InspectionItemsServerImpl implements InspectionItemsServer {

    @Autowired
    private InspectionItemsMapper inspectionItemsMapper;

    @Override
    public List<InspectionItems> getAllItems() {
        QueryWrapper<InspectionItems> queryWrapper = new QueryWrapper<InspectionItems>();
        queryWrapper.isNotNull("itemName");
        return inspectionItemsMapper.selectList(queryWrapper);
    }
}
