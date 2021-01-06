package com.hm.hospitalproject.domain;

import lombok.Data;

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

@Entity
@Data
public class patientInfo {
    //userid  主键
    @Id
    private Integer userId;
    //身份证号
    @Column
    private String shenfenzheng;
    //姓名
    @Column
    private String userName;
    //user性别
    @Column
    private String userSex;
    //user密码
    @Column
    private String userPassword;
    //user手机
    @Column
    private String userPhone;
    //user地址
    @Column
    private String userAddress;
    //user状态(保留：如果需要对用户权限做处理)
    @Column
    private String status;
    //user最后登录时间
    @Column
    private String lastLoginTime;


}
