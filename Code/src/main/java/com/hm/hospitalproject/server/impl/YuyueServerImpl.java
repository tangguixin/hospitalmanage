package com.hm.hospitalproject.server.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hm.hospitalproject.entity.OnlineGuahao;
import com.hm.hospitalproject.mapper.OnlineGuahaoMapper;
import com.hm.hospitalproject.server.YuyueServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/07/12:42
 * @Description:
 */

@Service
public class YuyueServerImpl implements YuyueServer {

    @Autowired
    OnlineGuahaoMapper onlineGuahaoMapper;
    @Override
    public Boolean addyuyue(OnlineGuahao onlineGuahao) {

        if ((onlineGuahaoMapper.insert(onlineGuahao)==1)){
            return true;
        }
        return false;
    }

    @Override
    public Boolean cancelyuyue(int yuyueid) {

        if (onlineGuahaoMapper.deleteById(yuyueid)==1){
            return true;
        }
        return false;
    }

    @Override
    public List<OnlineGuahao> getyuyue(int userId) {

        QueryWrapper<OnlineGuahao> queryWrapper = new QueryWrapper<OnlineGuahao>();
        queryWrapper.eq("userid",userId);
        List<OnlineGuahao> userInfoList = onlineGuahaoMapper.selectList(queryWrapper);
        return userInfoList;
    }

    @Override
    public List<OnlineGuahao> getyuyueAll() {
        QueryWrapper<OnlineGuahao> queryWrapper = new QueryWrapper<OnlineGuahao>();
        queryWrapper.isNotNull("userid");
        return onlineGuahaoMapper.selectList(queryWrapper);
    }
}
