package com.hm.hospitalproject.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
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

@Entity
@Data
public class onlineGuahao {
    //预约id  自增主键
    @Id
    private int orderId;
    //用户id
    @Column
    private int userid;    //用户表唯一标识符（外键）
    //预约科室名称
    @Column
    private String roomId;
    //医生姓名
    @Column
    private String doctorId;
    //是否成功
    @Column
    private boolean isSuccess;
    //是否取消
    @Column
    private boolean isCancel;
    //创建预约时间
    @Column
    private Timestamp createTime;

    /**
     * 预约类型
     */
    @Column
    private String type;

}
