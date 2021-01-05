package com.hm.hospitalproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/02/15:48
 * @Description:
 */
//患者基础信息表
public class patientInfor {
    //userid  主键
    private Integer userId;
    //身份证号
    private String shenfenzheng;
    //姓名
    private String userName;
    //user性别
    private String userSex;
    //user密码
    private String userPassword;
    //user手机
    private String userPhone;
    //user地址
    private String userAddress;
    //user状态(保留：如果需要对用户权限做处理)
    private String status;
    //user最后登录时间
    private String lastLoginTime;


}
