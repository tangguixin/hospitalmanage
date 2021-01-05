package com.hm.hospitalproject.domain;

import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/11:11
 * @Description:
 */
//在线预约信息表
public class onlineGuahao {
    //预约id  自增主键
    private int orderId;
    //用户id
    private int userid;    //用户表唯一标识符（外键）
    //预约科室名称
    private String roomId;
    //医生姓名
    private String doctorId;
    //预约日期
    private String transactDate;
    //预约开始时间
    private String transactbeginTime;
    private String TransactendTime;
    //是否成功
    private boolean isSuccess;
    //是否取消
    private boolean isCancel;
    //创建预约时间
    private Timestamp createTime;



}
