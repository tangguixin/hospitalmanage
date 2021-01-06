package com.hm.hospitalproject.server;

import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/06/12:15
 * @Description:
 */


@Service
public interface UserServer {

    /**
     * 用户登录
     * @param type
     * @param shenfenzheng
     * @param password
     * @return
     */
    public Boolean login(String shenfenzheng, String password, String type);

    /**
     * 修改新密码
     * @param shenfenzheng
     * @return
     */
    public Boolean clearVerification(String shenfenzheng);

    public int test();

}
