package com.hm.hospitalproject.entity;

import lombok.Data;


import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/11:11
 * @Description:
 */
//在线预约信息表


@Data
public class onlineGuahao {
    //预约id  自增主键

    private int orderId;
    //用户id

    private int userid;    //用户表唯一标识符（外键）

    private String roomId;
    //医生姓名

    private String doctorId;
    //是否成功

    private boolean isSuccess;
    //是否取消

    private boolean isCancel;
    //创建预约时间

    private Timestamp createTime;

    /**
     * 预约类型
     */

    private String type;

}
