package com.hm.hospitalproject.server.impl;


import com.hm.hospitalproject.entity.Users;
import com.hm.hospitalproject.mapper.UsersMapper;
import com.hm.hospitalproject.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    UsersMapper userMapper;


    @Override
    public Boolean login(String shenfenzheng, String password, String type) {
        return false;
    }

    @Override
    public Boolean clearVerification(String shenfenzheng) {
        return true;
    }

    @Override
    public int test() {
        Users users=new Users();
        users.setId(2);
        users.setShenfenzheng("500235199710097231");
        users.setPassword("123456");
        return userMapper.insert(users);
    }
}
