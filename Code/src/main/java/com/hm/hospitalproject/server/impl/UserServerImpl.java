package com.hm.hospitalproject.server.impl;

import com.hm.hospitalproject.entity.users;
import com.hm.hospitalproject.mapper.UserMapper;
import com.hm.hospitalproject.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/06/12:32
 * @Description:
 */

@Component
public class UserServerImpl implements UserServer {

    @Autowired
    private UserMapper userMapper;


    @Override
    public users finduserbyshenfenzheng(String shenfenzheng) {
        return null;
    }

    @Override
    public int login(String shenfenzheng, String password, HttpServletRequest request) {
        return 0;
    }

    @Override
    public int clearVerification(String shenfenzheng) {
        return 0;
    }

    @Override
    public List<users> getAlluser() {
        //mybats plus自带函数
      return userMapper.selectList(null);
    }
}
