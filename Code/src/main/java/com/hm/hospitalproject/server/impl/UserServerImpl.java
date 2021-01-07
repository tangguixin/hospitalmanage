package com.hm.hospitalproject.server.impl;


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
//        Users on=new Users();
//        on=userMapper.selectById(1);
//        if (on.getPassword().equals(password)&&on.getType().equals(type)){
//            return true;
//        }
        return true;
    }

    @Override
    public Boolean clearVerification(String shenfenzheng) {
        return true;
    }

    @Override
    public Users test() {

        return (Users) userMapper.selectById(1);

    }
}
