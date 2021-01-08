package com.hm.hospitalproject.server.impl;


import com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hm.hospitalproject.entity.Users;
import com.hm.hospitalproject.mapper.UsersMapper;
import com.hm.hospitalproject.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/06/12:32
 * @Description:
 */

@Service
public class UserServerImpl implements UserServer {


    @Autowired
    UsersMapper userMapper;


    @Override
    public Boolean login(String shenfenzheng, String password, String type) {

        QueryWrapper<Users> qw = new QueryWrapper<>();
        qw.eq("shenfenzheng",shenfenzheng);
        qw.eq("password",password);
        qw.eq("type",type);
        if (userMapper.selectOne(qw)!=null){
            return true;
        }

        return false;
    }

    @Override
    public Boolean clearVerification(String shenfenzheng) {
        return true;
    }

    @Override
    public Users test() {
        return userMapper.selectById(1);

    }
}
