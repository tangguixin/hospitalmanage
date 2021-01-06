package com.hm.hospitalproject.server;

import com.hm.hospitalproject.entity.users;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
     * 根据身份证号查找用户信息
     * @param shenfenzheng
     * @return
     */
    public users finduserbyshenfenzheng(String shenfenzheng);

    /**
     * 用户登录
     * @param shenfenzheng
     * @param password
     * @param request
     * @return
     */
    public int login(String shenfenzheng, String password, HttpServletRequest request);

    /**
     * 修改新密码
     * @param shenfenzheng
     * @return
     */
    public int clearVerification(String shenfenzheng);

    public List<users> getAlluser();
}
